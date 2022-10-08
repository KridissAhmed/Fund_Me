package tn.esprit.fundme.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.fundme.entities.Credits;
import tn.esprit.fundme.entities.Repayment;
@Repository
public interface RepayementRepository extends CrudRepository<Repayment, Long> {
	
	@Query("SELECT r FROM Repayment r WHERE term > :d and state = 0")
	List<Repayment>  unpaidRepayments(@Param("d") Date d);
	List<Repayment> findByCredit_ID(long id);
}
