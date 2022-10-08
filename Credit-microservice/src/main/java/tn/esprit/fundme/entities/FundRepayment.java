package tn.esprit.fundme.entities;

import java.io.Serializable;

import java.util.Date;
 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
 import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
 
public class FundRepayment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long ID ;
	@Temporal(TemporalType.DATE)
	private Date Term ;
	private float amount ;
	private boolean state;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Fund fund;


	public Long getID() {
		return ID;
	}


	public void setID(Long iD) {
		ID = iD;
	}


	public Date getTerm() {
		return Term;
	}


	public void setTerm(Date term) {
		Term = term;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}


	public Fund getFund() {
		return fund;
	}


	public void setFund(Fund fund) {
		this.fund = fund;
	}
	
	
}
