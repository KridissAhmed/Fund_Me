package tn.esprit.fundme.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Guarantor_documents")

public class Guarantor_documents implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Doc")
	private long id_Doc;
	
	private int id_card;
	private String employment_contat ;
public long getId_Doc() {
		return id_Doc;
	}

	public void setId_Doc(long id_Doc) {
		this.id_Doc = id_Doc;
	}

private String bank_statement ;

	
	public Guarantor_documents() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Guarantor_documents(int id_card, String employment_contat, String bank_statement) {
		super();
		this.id_card = id_card;
		this.employment_contat = employment_contat;
		this.bank_statement = bank_statement;
	}

	public int getId_card() {
		return id_card;
	}
	public void setId_card(int id_card) {
		this.id_card = id_card;
	}
	public String getEmployment_contat() {
		return employment_contat;
	}
	public void setEmployment_contat(String employment_contat) {
		this.employment_contat = employment_contat;
	}
	public String getBank_statement() {
		return bank_statement;
	}
	public void setBank_statement(String bank_statement) {
		this.bank_statement = bank_statement;
	}

	@Override
	public String toString() {
		return "guarantor_documents [id_card=" + id_card + ", employment_contat=" + employment_contat
				+ ", bank_statement=" + bank_statement + "]";
	}

}

