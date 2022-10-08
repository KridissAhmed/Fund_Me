package tn.esprit.fundme.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.fundme.entities.Fund;

@Repository
public interface FundRepository extends CrudRepository<Fund, Long>{

}
