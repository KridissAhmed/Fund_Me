package tn.esprit.fundme.services;

import java.util.List;

import tn.esprit.fundme.entities.FundRepayment;

public interface IFundRepaymentService {

	List<FundRepayment> retrieveAllFundRepayments();

	FundRepayment addFundRepayment(FundRepayment o);

	void deleteFundRepayment(Long id);

	FundRepayment updateFundRepayment(FundRepayment o);

	FundRepayment retrieveFundRepayment(Long id);
}
