package tn.esprit.fundme.entities;

import java.io.Serializable;
 
	
 
	public class Client_Documents implements Serializable {
		private static final long serialVersionUID = 1L;
	
		
	private long ID_card;	
	private long Phone;
	private String Mail;
	
	
	
	
	
	
	public long getID_card() {
		return ID_card;
	}
	public void setID_card(long iD_card) {
		ID_card = iD_card;
	}
	public long getPhone() {
		return Phone;
	}
	public void setPhone(long phone) {
		Phone = phone;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}

	
	}
