package tn.esprit.fundme.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.service.ResponseMessage;
import tn.esprit.fundme.entities.CreditState;
import tn.esprit.fundme.entities.Credits;
import tn.esprit.fundme.entities.Offer;
import tn.esprit.fundme.entities.ReponseMessage;
import tn.esprit.fundme.entities.User;
import tn.esprit.fundme.repositories.Custom;
import tn.esprit.fundme.repositories.ICustom;
import tn.esprit.fundme.services.ICreditsService;
import tn.esprit.fundme.services.IOfferService;
import tn.esprit.fundme.services.IRepaymentService;
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
 @RestController
@RequestMapping("/credits")
public class CreditsController {

	@Autowired
	ICreditsService creditsService;
	@Autowired
	IOfferService offerService;
	@Autowired 
	IRepaymentService repaymentService;
	@Autowired
	Custom custom;
	 
	
	@GetMapping("/select")
	@ResponseBody
	public List<Credits> getCredits() {
		List<Credits> listCredits = creditsService.retrieveAllCredits();
		return listCredits;
	}
	@GetMapping("/stat")
	@ResponseBody
	public Object stat() {
		 
		return custom.accepted();
	}
	@GetMapping("/total")
	@ResponseBody
	public Object stat2() {
		 
		return custom.total();
	}

	@GetMapping("/select/{id}")
	@ResponseBody
	public Credits getCredits(@PathVariable("id") Long Id) {
		Credits f = creditsService.retrieveCredits(Id);
		return f;
	}
	@GetMapping("/test/{id}")
	@ResponseBody
	public User x(@PathVariable("id") Long Id) {
		User u = creditsService.test(Id);
		return u;
 	}

	@PostMapping("/add")
	@ResponseBody
	public String addCredits(@RequestBody Credits x  ) {
 		
 		x.setState(CreditState.WAITING);
		String str = "request accepted waiting for confirmation";
		try {
			if( creditsService.fraudCheck(x))
				
			{
				int score = creditsService.scooring(x);
				System.out.println(score);
				Offer o = offerService.searchOfferScore(score);
				if(o!=null)
				{
					offerService.assignOfferToCredit(o, x);
					
					x.setState(CreditState.WAITING);
					
				}
				str= "request denied : Fraud";
				x.setState(CreditState.FRAUD);
			}
				
			
			else
			{
				int score = creditsService.scooring(x);
				System.out.println(score);
				Offer o = offerService.searchOfferScore(score);
				if(o!=null)
				{
					offerService.assignOfferToCredit(o, x);
					
					x.setState(CreditState.WAITING);
					
				}
				else {
					str = "request denied : Score not enough";
					x.setState(CreditState.REJECTED);
				}
				
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		creditsService.addCredits(x);
		return str;

	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void removeCredits(@PathVariable("id") Long Id) {
		creditsService.deleteCredits(Id);
	}

	@PutMapping("/update")
	@ResponseBody
	public Credits modifyCredits(@RequestBody Credits f) {
		return creditsService.updateCredits(f);
	}

	 
	@PutMapping("/accept/{id}")
	@ResponseBody
	public Credits acceptCredit(@PathVariable("id") Long Id) {
		Credits c = creditsService.acceptCredit(Id);
		repaymentService.addCredit(c);
		return c ;
 	}
	@PutMapping("/reject/{id}")
	@ResponseBody
	public Credits rejectCredit(@PathVariable("id") Long Id) {
 
		Credits c= creditsService.rejectCredit(Id);
		 return c ;
		 
		 
 	}
	@PostMapping("/sim")
	@ResponseBody
	public ReponseMessage sim(@RequestBody Credits x  ) {
 
			    String str = "";
				int score = creditsService.scooring(x);
				System.out.println("nnnnnn");
				Offer o = offerService.searchOfferScore(score);
				System.out.println(o.getInterestRate());

				if(o!=null)
				{
					str= creditsService.simulation(o.getInterestRate(), x.getAmount(), x.getDuration_months());
					
				}
				else {
					str = "unable to process you request try again";
					 
				}
				
				
				
				ReponseMessage m = new ReponseMessage();
				m.setStr(str);
				System.out.println(m + "77777777777777777");
			 
		 
	 
		return m;

	}


}
