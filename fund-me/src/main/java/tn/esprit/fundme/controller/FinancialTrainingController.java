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

import tn.esprit.fundme.entities.DomainClient;
import tn.esprit.fundme.entities.FinancialTraining;
import tn.esprit.fundme.services.IFinancialTrainingService;
import tn.esprit.fundme.services.IUserService;

@RestController
@RequestMapping("/financialtraining")
public class FinancialTrainingController {
	
	@Autowired
	IFinancialTrainingService financialtrainingservice ;
	@Autowired
	IUserService userservice ;
	
	//http://localhost:8083/springMVC/financialtraining/retrieve-all-financialtrainings
		@GetMapping("/retrieve-all-financialtrainings")
		@ResponseBody
		public List<FinancialTraining>getFinancialTrainings(){
			List<FinancialTraining>listFinancialTrainings = financialtrainingservice.retrieveAllFinancialTrainings();
			return listFinancialTrainings;
		}
		@GetMapping("/getbydomain/{x}")
		@ResponseBody
		public List<FinancialTraining>getbydomain(@PathVariable("x") DomainClient d ){
			List<FinancialTraining>listFinancialTrainings = financialtrainingservice.retrieveAllFinancialTrainingsByDomain(d);
 			return listFinancialTrainings;
		}
		
		// http://localhost:8089/SpringMVC/financialtraining/retrieve-financialtraining/1
		@GetMapping("/retrieve-financialtraining/{financialtraining-id}")
		@ResponseBody
		public FinancialTraining retrieveFinancialTraining(@PathVariable("financialtraining-id") Long financialtrainingId) {
		return financialtrainingservice.retrieveFinancialTraining(financialtrainingId);
		}

		
		// http://localhost:8089/SpringMVC/financialtraining/add-financialtraining
		@PostMapping("/add-financialtraining")
		@ResponseBody
		public FinancialTraining addFinancialTraining(@RequestBody FinancialTraining t ,  Long User_id)
		{
			FinancialTraining financialtraining = financialtrainingservice.addFinancialTraining(t);
		return financialtraining;

		}
		// http://localhost:8089/SpringMVC/FinancialTraining/remove-financialtraining/{financialtraining-id}
		@DeleteMapping("/remove-financialtraining/{financialtraining-id}")
		@ResponseBody
		public void removeFinancialTraining(@PathVariable("financialtraining-id") Long financialtrainingId) {
			financialtrainingservice.deleteFinancialTraining(financialtrainingId);
		}

		// http://localhost:8089/SpringMVC/financialtraining/modify-financialtraining
		@PutMapping("/modify-financialtraining")
		@ResponseBody
		public FinancialTraining modifyFinancialTraining(@RequestBody FinancialTraining financialtraining ,  @PathVariable("training-id") Long idTraining) {
		return financialtrainingservice.updateFinancialTraining(financialtraining,idTraining);
		}
		
		
		

}
