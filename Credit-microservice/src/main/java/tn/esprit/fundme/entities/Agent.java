package tn.esprit.fundme.entities;

import java.io.Serializable;
 


public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long id_Agent;
	private String Mdp_Agent;
	private String FirstName;
	private String LastName;
	private String Cin;
	private String Type;
	

	
	
	
	public Long getId_Agent() {
		return id_Agent;
	}
	public void setId_Agent(Long id_Agent) {
		this.id_Agent = id_Agent;
	}
	public String getMdp_Agent() {
		return Mdp_Agent;
	}
	public void setMdp_Agent(String mdp_Agent) {
		Mdp_Agent = mdp_Agent;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getCin() {
		return Cin;
	}
	public void setCin(String cin) {
		Cin = cin;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
	

}
