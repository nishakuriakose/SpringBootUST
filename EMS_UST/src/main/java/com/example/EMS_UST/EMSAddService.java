package com.example.EMS_UST;

import java.util.Optional;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EMSAddService {
	
	@Autowired
	EMSRepository repository;
	
	public Boolean checkEMPAlreadyExist(String id) {
		
		Optional<EMS> ems=repository.findById(id);
		
		if (ems.isPresent()) {
			return true;
			
		}
		else
		{
			return false;
		
			
		}
		
	}
	

}
