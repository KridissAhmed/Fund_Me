package tn.esprit.fundme.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.fundme.entities.Guarantor;

@Repository
public interface GuarantorRepository extends CrudRepository<Guarantor, Long> {

	 
}
