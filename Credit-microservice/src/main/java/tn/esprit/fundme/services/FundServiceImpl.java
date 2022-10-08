package tn.esprit.fundme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import tn.esprit.fundme.entities.Fund;
 import tn.esprit.fundme.repositories.FundRepository;
@Service
public class FundServiceImpl implements IFundService{

	@Autowired
	FundRepository fundRepository ;
	
	
	@Override
	public List<Fund> retrieveAllFunds() {
		 
		return (List<Fund>) fundRepository.findAll();
	}

	@Override
	public Fund addFund(Fund f, Long idAgent) {
	//	Agent a  = agentRepository.findById(idAgent).orElse(null);
	   // f.setAgent_fund(a);
	    fundRepository.save(f);
		return f;
	}

	@Override
	public void deleteFund(Long id) {
		 fundRepository.deleteById(id);
		
	}

	@Override
	public Fund updateFund(Fund f , Long idAgent) {
		//Agent a  = agentRepository.findById(idAgent).orElse(null);
	   // f.setAgent_fund(a);
	    fundRepository.save(f);
		return f;
	}

	@Override
	public Fund retrieveFund(Long id) {
		 
		return fundRepository.findById(id).orElse(null);
	}

}
