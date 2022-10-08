package tn.esprit.fundme.services;

import java.util.List;

import tn.esprit.fundme.entities.Fund;

 
public interface IFundService {
 
	List<Fund> retrieveAllFunds();

	Fund addFund(Fund f , Long idAgent);

	void deleteFund(Long id);

	Fund updateFund(Fund f , Long idAgent);

	Fund retrieveFund(Long id);
}
