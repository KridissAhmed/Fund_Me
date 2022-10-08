package tn.esprit.fundme.services;

import java.util.List;

import tn.esprit.fundme.entities.Guarantor_documents;
public interface GuarantorDocumentsService {

	List<Guarantor_documents> retrieveAllGuarantor_documents(); 
	Guarantor_documents addGuarantor_documents(Guarantor_documents G); 
	Guarantor_documents updateGuarantor_documents(Guarantor_documents G);
	Guarantor_documents retrieveGuarantor_documents(Long id); 
	void removeGuarantor_documents(Long id);
}

