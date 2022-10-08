package tn.esprit.fundme.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.fundme.entities.Guarantor_documents;
import tn.esprit.fundme.repositories.GuarantorDocumentsRepository;
public class GuarantorDocumentsServicelmpl implements GuarantorDocumentsService {
	@Autowired
	GuarantorDocumentsRepository GuarantorDocuments;
	@Override
	
	public List<Guarantor_documents> retrieveAllGuarantor_documents() {
		return (List<Guarantor_documents>) GuarantorDocuments.findAll();
	}
	
	@Override
	public Guarantor_documents addGuarantor_documents(Guarantor_documents G) {
		return GuarantorDocuments.save(G);
	}
	
	@Override
	public Guarantor_documents updateGuarantor_documents(Guarantor_documents G) {
		GuarantorDocuments.save(G);
		return G;
	}
	
	@Override
	public Guarantor_documents retrieveGuarantor_documents(Long id) {
		return GuarantorDocuments.findById(id).orElse(null);
	}
	
	@Override
	public void removeGuarantor_documents(Long id) {
		GuarantorDocuments.deleteById(id);
	}


}
