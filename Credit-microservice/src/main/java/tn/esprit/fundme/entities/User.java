package tn.esprit.fundme.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
 
public class User   {
	private static final long serialVersionUID = 1L;
	
 
	private Long id_User;
	
	private String Job ;
	private float Salary;
	private String Civil_status;
	private String Cin;
	@Enumerated(EnumType.STRING)
    private  DomainClient domain ;
 	private ClientDocuments UserDocuments;
	
 	private UserType logUser;
	
	
	public UserType getLogUser() {
		return logUser;
	}
	public void setLogUser(UserType logUser) {
		this.logUser = logUser;
	}
	public ClientDocuments getUserDocuments() {
		return UserDocuments;
	}
	public void setUserDocuments(ClientDocuments userDocuments) {
		UserDocuments = userDocuments;
	}
 
	 
	public DomainClient getDomain() {
		return domain;
	}
	public void setDomain(DomainClient domain) {
		this.domain = domain;
	}
	 
 	 
	
	
	 
	
	 
	public Long getId_User() {
		return id_User;
	}
	public void setId_User(Long id_User) {
		this.id_User = id_User;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		Salary = salary;
	}
	public String getCivil_status() {
		return Civil_status;
	}
	public void setCivil_status(String civil_status) {
		Civil_status = civil_status;
	}
	
	
	public String getCin() {
		return Cin;
	}
	public void setCin(String cin) {
		Cin = cin;
	}
	



	
}
