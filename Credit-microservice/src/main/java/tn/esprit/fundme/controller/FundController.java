package tn.esprit.fundme.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

 import tn.esprit.fundme.entities.Fund;
import tn.esprit.fundme.services.IFundService;
  
@RestController
@RequestMapping("/fund")
public class FundController {
	@Autowired
	IFundService fundService;
	
	
    
	@GetMapping("/select")
	@ResponseBody
	public List<Fund>getFunds(){
		List<Fund>listFunds = fundService.retrieveAllFunds();
		return listFunds;
	}
	@GetMapping("/select/{id}")
	@ResponseBody
	public Fund getFund(@PathVariable("id") Long Id){
		 Fund f = fundService.retrieveFund(Id);
		return f;
	}
	
	@PostMapping("/add/{id}")
	@ResponseBody
	public Fund addFund(@RequestBody Fund x , @PathVariable("id") Long Id )
	{
	Fund f = fundService.addFund(x, Id);
	return f;

	}
	 
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void removeFund(@PathVariable("id") Long Id) {
	fundService.deleteFund(Id);
	}

 	@PutMapping("/update/{id}")
	@ResponseBody
	public Fund modifyFund(@RequestBody Fund f ,@PathVariable("id") Long Id ) {
	return fundService.updateFund(f , Id);
	}
}
