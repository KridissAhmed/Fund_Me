package tn.esprit.fundme.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Collateral")
  
public class Collateral implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Collateral")
	private long id_Collateral;

	public long getId_Collateral() {
		return id_Collateral;
	}
	public void setId_Collateral(long id_Collateral) {
		this.id_Collateral = id_Collateral;
	}
	public Credits getCredit() {
		return credit;
	}
	public void setCredit(Credits credit) {
		this.credit = credit;
	}
	private int serial_number;
	private float value;
	private String type;
	private String adress;
	private String description;
	
	
	
	@ManyToOne
	 Credits credit;
	

	public int getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "collateral [serial_number=" + serial_number + ", value=" + value + ", type=" + type + ", adress="
				+ adress + ", description=" + description + "]";
	}
	

}
