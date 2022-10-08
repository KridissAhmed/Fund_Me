package tn.esprit.fundme.services;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.math3.util.Precision;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tn.esprit.fundme.entities.CreditState;
import tn.esprit.fundme.entities.Credits;
import tn.esprit.fundme.entities.User;
import tn.esprit.fundme.repositories.CreditsRepository;
 
@Service
public class CreditsServiceImlp implements ICreditsService {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	CreditsRepository creditsrepository;
   
	@Override
	public List<Credits> retrieveAllCredits() {
		return (List<Credits>) creditsrepository.findAll();
	}

	@Override
	public Credits addCredits(Credits cr) {
		cr.setStartDate(new Date());
		creditsrepository.save(cr);
		return cr;
	}

	@Override
	public void deleteCredits(Long id) {
		creditsrepository.deleteById(id);

	}

	@Override
	public Credits updateCredits(Credits cr) {
		//creditsrepository.save(cr);
		
		return cr;
	}

	@Override
	public Credits retrieveCredits(Long id) {
		return creditsrepository.findById(id).orElse(null);
	}
	@Override
	public User test (Long id) {
		User u = restTemplate.getForObject("http://localhost:8093/user/select/1", User.class);
		System.out.println(u);
		return u;
	}

	@Override
	public String simulation(double annualInterestRate, double amount, int numberOfYears) {
		String map = "";

		int numberOfMonths = numberOfYears ;
		double monthlyInterestRate = annualInterestRate / 1200;

		double monthlyPayment =  Precision.round(amount * monthlyInterestRate
				/ (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfMonths)), 2);
	    double totalPayment = Precision.round(monthlyPayment * numberOfMonths,2);
	    double withoutinterest = Precision.round(amount,2);
	    double surplus = Precision.round(totalPayment - amount,2) ;
	    
	     map = "You want a credit of "+ amount +" dinars You can repay this credit over a period of "+ numberOfMonths+" months"
	     		+ " for a monthly repayment of "+monthlyPayment+"dinars "
	     		+ "  : the total amount is "+totalPayment+" dinars and the surplus is "+surplus + " dinars";
		return map;

	}


	@Override
	public boolean fraudCheck(Credits c) throws Exception {
		User u = restTemplate.getForObject("http://localhost:8093/User/afficher/"+c.getUser_credit(), User.class);
		
		String FILE_NAME = "C:\\Users\\AK47\\Desktop\\x.xlsx";
		List<String> names = new ArrayList<String>();
		List<String> families = new ArrayList<String>();
		List<String> birthdays = new ArrayList<String>();
		List<String> cin = new ArrayList<String>();
		JaroWinklerSimilarity j = new JaroWinklerSimilarity();
		
		Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US)
				.parse(c.getBirthday()  + "");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		int year = calendar.get(Calendar.YEAR);

		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String mm = month + "";
		String d = day + "";
		if (month < 10)
			mm = "0" + month;
		if (day < 10)
			d = "0" + day;
 		String dateS= d+"/"+mm+"/"+year;
 		String cin1  = u.getCin() ;
		String cin2  =  u.getCin() ;
		if(cin1.length()==8) {
			cin1 = cin1.substring(0, 4);
			cin2 = cin2.substring(5, 8);
		}
		
		Map<Integer, List<String>> data = excelImport(FILE_NAME);
		String temp = "";
		Iterator<Entry<Integer, List<String>>> iterator = data.entrySet().iterator();
		while (iterator.hasNext()) {
			
			Entry<Integer, List<String>> m = iterator.next();

			List<String> value = m.getValue();
			temp = value.get(1).toUpperCase().trim();

			if (temp.contains("BEN"))
				names.add(temp.substring(0, temp.indexOf("BEN")));
			else
				names.add(temp);

			families.add(value.get(2).toUpperCase().trim());
			if (!value.get(10).contains("passeport")) {
				if (value.get(10).contains("*****")) {

					cin.add(value.get(10)
							.substring(value.get(10).indexOf("*****") + 5, value.get(10).indexOf("*****") + 8).trim());

				} else if (value.get(10).contains("***")) {
					cin.add(value.get(10).substring(value.get(10).indexOf("***") - 5, value.get(10).indexOf("***"))
							.trim());
				} else
					cin.add("");
			} else
				cin.add("");
			if (value.get(3).contains("/")) {

				String regex = "([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}";
				Matcher matcher = Pattern.compile(regex).matcher(value.get(3));
				if (matcher.find()) {
					birthdays.add(matcher.group().trim());
				}

			} else
				birthdays.add("");

		}

		if ((names.size() == cin.size()) && (names.size() == birthdays.size())) {
			

			for (int i = 0; i < names.size(); i++) {
				 
				if ((j.apply(names.get(i), u.getLogUser().getFirstName().toUpperCase().trim()) > 0.75) && (j.apply(families.get(i).trim(), u.getLogUser().getLastName().toUpperCase().trim()) > 0.75)
						&& (birthdays.get(i).equals(dateS))
					&& ((cin.get(i).equals(cin1)) || (cin.get(i).equals(cin2)))) {
					

					return true;
				}

			}

		}

		return false;
	}

	public Map<Integer, List<String>> excelImport(String FILE_NAME) throws Exception {

		FileInputStream file = new FileInputStream(FILE_NAME);
		Workbook workbook = new XSSFWorkbook(file);

		Sheet sheet = workbook.getSheetAt(0);
		Map<Integer, List<String>> data = new HashMap<>();
		int i = 0;

		for (Row row : sheet) {
			if ((i != 0) && (i != 1)) {

				data.put(i, new ArrayList<String>());

				for (Cell cell : row) {

					switch (cell.getCellType()) {
					case STRING:
						data.get(new Integer(i)).add(cell.getRichStringCellValue().getString());
						break;
					case NUMERIC:

						if (DateUtil.isCellDateFormatted(cell)) {
							Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US)
									.parse(cell.getDateCellValue() + "");
							Calendar calendar = new GregorianCalendar();
							calendar.setTime(date);
							int year = calendar.get(Calendar.YEAR);

							int month = calendar.get(Calendar.MONTH) + 1;
							int day = calendar.get(Calendar.DAY_OF_MONTH);
							String m = month + "";
							String d = day + "";
							if (month < 10)
								m = "0" + month;
							if (day < 10)
								d = "0" + day;
							data.get(i).add(d + "/" + m + "/" + year);
						} else {
							data.get(i).add(cell.getNumericCellValue() + "");
						}
						break;
					case BOOLEAN:
						data.get(i).add(cell.getBooleanCellValue() + "");
						break;
					case FORMULA:
						data.get(i).add(cell.getCellFormula() + "");
						break;
					default:
						data.get(new Integer(i)).add(" ");
					}

				}
			}

			i++;
		}
		workbook.close();

		return data;
	}

	@Override
	public int scooring(Credits c) {
		
		int score = 0;
		int  age;
 		LocalDate now = LocalDate.now();
 		LocalDate birthdate = c.getBirthday().toInstant()
 			      .atZone(ZoneId.systemDefault())
 			      .toLocalDate();
		 if ((c.getBirthday() != null) && (now != null)) {
			   age = (int)  ChronoUnit.YEARS.between(birthdate , now);
	             
	        } else {
	            return 0;
	        }
		score += c.getJobActivity().getScore();
		score += c.getGender().getScore();		
		if (c.getDuration_months() <= 12) score+=5;
		else if (c.getDuration_months() <= 24) score+=4;
		else if (c.getDuration_months() <= 36) score+=3;
		else score+=1;
		if (age <= 29) score+=3;
		else if (age <= 39) score+=5;
		else if (age <= 59) score+=3;
		else if (age <= 79) score+=4;
		else score+=1;
		return score;
	}

	@Override
	public Credits affectUser(Long Id , Credits c) {
		
 		c.setUser_credit(Id);
 		
 		return c;
	}

	@Override
	public Credits acceptCredit(Long id) {
		Credits c =creditsrepository.findById(id).orElse(null);
		if (c!=null) {
			c.setState(CreditState.ACCEPTED);
			
		}
	 
		return c;
		
		
	}

	@Override
	public List<Credits> afficherselongarantor(Long id) {
		
		return creditsrepository.findByGuarantor_Id(id);
	}

	@Override
	public Credits rejectCredit(Long id) {
 
		Credits c =creditsrepository.findById(id).orElse(null);
 		if (c!=null) {
			c.setState(CreditState.REJECTED);
			creditsrepository.save(c);
			System.out.println("xxxxxxxxxx");

		}
		return c ;
	}
	 
}
