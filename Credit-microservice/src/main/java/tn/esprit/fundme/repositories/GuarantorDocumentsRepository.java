package tn.esprit.fundme.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.fundme.entities.Guarantor_documents;
@Repository
public interface GuarantorDocumentsRepository extends CrudRepository<Guarantor_documents, Long> {

}
