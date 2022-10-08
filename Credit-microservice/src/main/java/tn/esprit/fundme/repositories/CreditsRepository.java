package tn.esprit.fundme.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.fundme.entities.Credits;
import tn.esprit.fundme.entities.Month;

@Repository
public interface CreditsRepository extends CrudRepository<Credits , Long> {
	 
	List<Credits> findByGuarantor_Id(Long id);
	
	@Query( value = "SELECT * FROM USERS u WHERE u.status = 1", nativeQuery = true)
		List<Month>stat();
}
