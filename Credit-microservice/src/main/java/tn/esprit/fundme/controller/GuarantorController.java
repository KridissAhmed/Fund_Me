package tn.esprit.fundme.controller;

import java.util.List;

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

import tn.esprit.fundme.entities.Credits;
 import tn.esprit.fundme.entities.Repayment;
import tn.esprit.fundme.services.GuarantorService;
import tn.esprit.fundme.services.ICreditsService;
import tn.esprit.fundme.services.IRepaymentService;
import tn.esprit.fundme.entities.Guarantor;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

@RestController
@RequestMapping("/garantor")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class GuarantorController {
	
	@Autowired
	GuarantorService guarantorservice ;

	
	
	@GetMapping("/select")
	@ResponseBody
	public List<Guarantor> getGuarantor(){
		List<Guarantor>listGuarantor =guarantorservice.retrieveAllGuarantors();
		return listGuarantor;
	}
	
	
	@GetMapping("/select/{operateur-id}")
	@ResponseBody
	public Guarantor retrieveGuarantor(@PathVariable("operateur-id") Long GuarantorId) {
	return guarantorservice.retrieveGuarantor(GuarantorId);
	}

	
	@PostMapping("/add")
	@ResponseBody
	public Guarantor Guarantor(@RequestBody Guarantor G)
	{
			return guarantorservice.addGuarantor(G);

	}
	
	@DeleteMapping("/delete/{operateur-id}")
	@ResponseBody
	public void removeGuarantor(@PathVariable("operateur-id") Long guarantorId) {
		guarantorservice.removeGuarantor(guarantorId);
	}

	@PutMapping("/update")
	@ResponseBody
	public Guarantor modifyGuarantor(@RequestBody Guarantor guarantor) {
	return guarantorservice.updateGuarantor(guarantor);
	}
	 
	
	
	

}
