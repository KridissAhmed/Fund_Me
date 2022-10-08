package tn.esprit.fundme.services;

import java.util.List;

import tn.esprit.fundme.entities.Guarantor;

public interface GuarantorService {
	List<Guarantor> retrieveAllGuarantors(); 
	Guarantor addGuarantor(Guarantor G); 
	Guarantor updateGuarantor(Guarantor G);
	Guarantor retrieveGuarantor(Long id); 
	void removeGuarantor(Long id);
	
}
