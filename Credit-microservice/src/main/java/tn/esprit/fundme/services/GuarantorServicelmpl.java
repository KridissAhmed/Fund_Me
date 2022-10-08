package tn.esprit.fundme.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.fundme.entities.Guarantor;
import tn.esprit.fundme.repositories.GuarantorRepository;

@Service
public class GuarantorServicelmpl implements GuarantorService  {

		@Autowired
		GuarantorRepository GuarantorRepository;
		
		@Override
		public List<Guarantor> retrieveAllGuarantors() {
			return (List<Guarantor>) GuarantorRepository.findAll();
		}
		
		@Override
		public Guarantor addGuarantor(Guarantor G) {
			return GuarantorRepository.save(G);
		}
		
		@Override
		public Guarantor updateGuarantor(Guarantor G) {
			GuarantorRepository.save(G);
			return G;
		}
		
		@Override
		public Guarantor retrieveGuarantor(Long id) {
			return GuarantorRepository.findById(id).orElse(null);
		}
		
		@Override
		public void removeGuarantor(Long id) {
			GuarantorRepository.deleteById(id);
		}

}
