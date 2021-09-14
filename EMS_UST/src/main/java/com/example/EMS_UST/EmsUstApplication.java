package com.example.EMS_UST;
import java.util.List;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EmsUstApplication //implements CommandLineRunner {

{
	//@Autowired
	//EMSRepository repository;
	
	
	public static void main(String[] args) {
		 SpringApplication.run(EmsUstApplication.class, args);
	   
      }
}


	/*
	@Override
	public void run(String...  args) throws Exception{
	
	EMS ems=repository.findById("EMP001").get();
	
	System.out.println(ems.geteSAL());
	System.out.println(ems.geteID());
	System.out.println(ems.geteName());
	
	EMS ems1= new EMS();
	ems1.seteID("EMP005");
	ems1.seteName("Azees");
	ems1.seteSAL("50000");
	repository.save(ems1);	
	
	
     List<EMS> allrecords=repository.findAll();
      
	  for (EMS items: allrecords) { 
		  System.out.println(items.geteName());
 }
	 
	 /* repository.delete(ems1);
	 */
	
	
	

		


