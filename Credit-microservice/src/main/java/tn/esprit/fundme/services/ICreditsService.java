package tn.esprit.fundme.services;

 import java.util.List;
import java.util.Map;

import tn.esprit.fundme.entities.Credits;
import tn.esprit.fundme.entities.User;

public interface ICreditsService {
	List<Credits> retrieveAllCredits();

	Credits addCredits(Credits cr);
	Credits affectUser(Long Id, Credits c);

	void deleteCredits(Long id);

	Credits updateCredits(Credits cr);

	Credits retrieveCredits(Long id);
	
	String simulation(double annualInterestRate, double amount, int numberOfYears);
	
	int scooring(Credits c);
	
	 boolean fraudCheck(Credits c) throws Exception;
	 
	 Credits  acceptCredit(Long id);
	 Credits  rejectCredit(Long id);
	 
	 Map<Integer, List<String>> excelImport(String FILE_NAME) throws Exception;
	 public User test (Long id) ;

	List<Credits> afficherselongarantor(Long id);
	  

}
