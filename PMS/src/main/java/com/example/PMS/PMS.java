package com.example.PMS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity 
//This tells the JPA that this class contains all the details of Tables


@Table(name="PMSUST1")

public class PMS {
	
	private String pID;
	private String pNAME;
	private String pPRICE;
	
	
	@Id
	
	
	@Column(name="id")
	public String getpID() {
		return pID;
	}
	
	
	
	@Column(name="product")
	public String getpNAME() {
		return pNAME;
	}
	
	@Column(name="price")
	public String getpPRICE() {
		return pPRICE;
	}
	
	
	public void setpID(String pID) {
		this.pID = pID;
	}
	
	public void setpNAME(String pNAME) {
		this.pNAME = pNAME;
	}
	

	
	public void setpPRICE(String pPRICE) {
		this.pPRICE = pPRICE;
	}
	
	

}
