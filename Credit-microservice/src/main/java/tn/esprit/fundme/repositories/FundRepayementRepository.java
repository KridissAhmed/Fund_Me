package tn.esprit.fundme.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
 import tn.esprit.fundme.entities.FundRepayment;

@Repository
public interface FundRepayementRepository extends CrudRepository<FundRepayment , Long>  {

}
