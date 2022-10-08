package tn.esprit.fundme.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 import javax.persistence.OneToMany;
import javax.persistence.Table;

 
import com.fasterxml.jackson.annotation.JsonProperty;
 import com.fasterxml.jackson.annotation.JsonProperty.Access;

 
 @Entity
 @Table(name = "Offer")
 
public class Offer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long ID ;
	private String name ;
	private String description ;
	private float interestRate;
	private int minScore;
	private int maxScore;
	@JsonProperty(access = Access.WRITE_ONLY)
 	@OneToMany(cascade = CascadeType.ALL,mappedBy = "offer")
 	private Set<Credits> credit;
	
	public int getMinScore() {
		return minScore;
	}
	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}
	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	public Set<Credits> getCredit() {
		return credit;
	}
	public void setCredit(Set<Credits> credit) {
		this.credit = credit;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
