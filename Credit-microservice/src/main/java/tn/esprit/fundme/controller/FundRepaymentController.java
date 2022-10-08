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

import tn.esprit.fundme.entities.FundRepayment;
import tn.esprit.fundme.services.IFundRepaymentService;

@RestController
@RequestMapping("fundRepayment")
public class FundRepaymentController {
	
	@Autowired
	IFundRepaymentService fundRepaymentService;
	
	@GetMapping("/select")
	@ResponseBody
	public List<FundRepayment>getFundRepayment(){
		List<FundRepayment>listFundRepayments = fundRepaymentService.retrieveAllFundRepayments();
		return listFundRepayments;
	}
	@GetMapping("/select/{id}")
	@ResponseBody
	public FundRepayment getFundRepayment(@PathVariable("id") Long Id){
		 FundRepayment f = fundRepaymentService.retrieveFundRepayment(Id);
		return f;
	}
	
	@PostMapping("/add")
	@ResponseBody
	public FundRepayment addFundRepayment(@RequestBody FundRepayment x  )
	{
	FundRepayment f = fundRepaymentService.addFundRepayment(x);
	return f;

	}
	 
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void removeFundRepayment(@PathVariable("id") Long Id) {
	fundRepaymentService.deleteFundRepayment(Id);
	}

 	@PutMapping("/update")
	@ResponseBody
	public FundRepayment modifyFundRepayment(@RequestBody FundRepayment f  ) {
	return fundRepaymentService.updateFundRepayment(f);
	}

}
