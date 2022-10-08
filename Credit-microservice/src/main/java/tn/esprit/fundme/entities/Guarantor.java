package tn.esprit.fundme.entities;




import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
 


@Entity
@Table(name = "Guarantor")
public class Guarantor implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	
	private long id  ;
	private String type ;
	private String description;
	private float salary;
	private Long phone_number ;
	@OneToOne
	private Guarantor_documents guarantor_documents;
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Credits> credit;
 
 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Guarantor_documents getGuarantor_documents() {
		return guarantor_documents;
	}
	public void setGuarantor_documents(Guarantor_documents guarantor_documents) {
		this.guarantor_documents = guarantor_documents;
	}
	public Set<Credits> getCredit() {
		return credit;
	}
	public void setCredit(Set<Credits> credit) {
		this.credit = credit;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "guarantor [id_guarantor=" + id + ", type=" + type + ", description=" + description
				+ ", salary=" + salary + ", phone_number=" + phone_number + "]";
	}
	

}
