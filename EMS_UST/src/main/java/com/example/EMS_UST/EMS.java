package com.example.EMS_UST;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity 
//This tells the JPA that this class contains all the details of Tables


@Table(name="EMPUST")

public class EMS {
	
	
	private String eName;
	private String  eID;
	private String  eSAL;
	
	@Id
	

	@Column(name="eid")
	public String geteID() {
		return eID;
	}
	
	@Column(name="ename")
	public String geteName() {
		return eName;
	}
	
	
	

	@Column(name="esal")
	public String geteSAL() {
		return eSAL;
	}
	
	
	public void seteName(String eName) {
		this.eName = eName;
	}
	
	
	public void seteID(String eID) {
		this.eID = eID;
	}
	
	
	
	public void seteSAL(String eSAL) {
		this.eSAL = eSAL;
	}

}
