package tn.esprit.fundme.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Credits")
 
public class Credits implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long ID ;
	private float amount;
 	@Enumerated(EnumType.STRING)
	private JobActivity jobActivity;
	@Enumerated(EnumType.STRING)
	private CreditState state ;
	@Temporal(TemporalType.DATE)
	private Date startDate ;
	@Temporal(TemporalType.DATE)
	private Date birthday ;
	@Enumerated(EnumType.STRING)
	private Gender gender ; 	
	private int Duration_months; 
	 
 
	private Long agent_credit;
	

	private Long user_credit;
  	@ManyToOne
 	private Offer offer;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "credit")
	private Set<Collateral> collateral;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "credit")
 	private Set<Repayment> repayment;
	@ManyToMany(mappedBy="credit", cascade = CascadeType.ALL)
	private Set<Guarantor> guarantor;

	
	
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getDuration_months() {
		return Duration_months;
	}
	public void setDuration_months(int duration_months) {
		Duration_months = duration_months;
	}
 
	public JobActivity getJobActivity() {
		return jobActivity;
	}
	public void setJobActivity(JobActivity jobActivity) {
		this.jobActivity = jobActivity;
	}
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	public Set<Collateral> getCollateral() {
		return collateral;
	}
	public void setCollateral(Set<Collateral> collateral) {
		this.collateral = collateral;
	}
	public Set<Repayment> getRepayment() {
		return repayment;
	}
	public void setRepayment(Set<Repayment> repayment) {
		this.repayment = repayment;
	}
	public Set<Guarantor> getGuarantor() {
		return guarantor;
	}
	public void setGuarantor(Set<Guarantor> guarantor) {
		this.guarantor = guarantor;
	}
	
	public Long getAgent_credit() {
		return agent_credit;
	}
	public void setAgent_credit(Long agent_credit) {
		this.agent_credit = agent_credit;
	}
	public Long getUser_credit() {
		return user_credit;
	}
	public void setUser_credit(Long user_credit) {
		this.user_credit = user_credit;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
 
	public CreditState getState() {
		return state;
	}
	public void setState(CreditState state) {
		this.state = state;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
	
	
	
	
}
