package tn.esprit.fundme.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Fund  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long ID ;
	private String currency ; 
	private float amount ;
	private float returnedAmount ;
	private float interestRate;
	@Temporal(TemporalType.DATE)
	private Date startDate ;
	@Temporal(TemporalType.DATE)
	private Date endDate ;
	
	Long agent_fund;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "fund")
	private Set<FundRepayment> fundrepayment;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getReturnedAmount() {
		return returnedAmount;
	}

	public void setReturnedAmount(float returnedAmount) {
		this.returnedAmount = returnedAmount;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getAgent_fund() {
		return agent_fund;
	}

	public void setAgent_fund(Long agent_fund) {
		this.agent_fund = agent_fund;
	}

	public Set<FundRepayment> getFundrepayment() {
		return fundrepayment;
	}

	public void setFundrepayment(Set<FundRepayment> fundrepayment) {
		this.fundrepayment = fundrepayment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
