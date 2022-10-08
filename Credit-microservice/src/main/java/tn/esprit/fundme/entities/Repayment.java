package tn.esprit.fundme.entities;

import java.io.Serializable;

import java.util.Date;
 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Repayment")

public class Repayment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long ID ;
	@Temporal(TemporalType.DATE)
	private Date Term ;
	private double amount ;
	private boolean state;
	
	public Repayment() {
		super();
	}
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
 	private Credits credit;
	
	
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Credits getCredit() {
		return credit;
	}
	public void setCredit(Credits credit) {
		this.credit = credit;
	}
	
	public Repayment(Date term, double amount, boolean state, Credits credit) {
		super();
		Term = term;
		this.amount = amount;
		this.state = state;
		this.credit = credit;
	}
	
	
}
