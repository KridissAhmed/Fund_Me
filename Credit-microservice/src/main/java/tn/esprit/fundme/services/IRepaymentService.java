package tn.esprit.fundme.services;

import java.util.List;

import tn.esprit.fundme.entities.Credits;
import tn.esprit.fundme.entities.Repayment;

public interface IRepaymentService {

	List<Repayment> retrieveAllRepayments();
	List<Repayment> getbycredits(long id);

	Repayment addRepayment(Repayment o);

	void deleteRepayment(Long id);

	Repayment updateRepayment(Repayment o);

	Repayment retrieveRepayment(Long id);
	
	void notification();
	
	List<Repayment> addCredit(Credits c);
	public List<Repayment> retrieveUnpaidRepayments();
 	
}
