package com.example.PMS;

import java.util.Optional;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PMSAddService {
	
	
	
		@Autowired
		PMSRepository repository;
		
		public Boolean checkPMSAlreadyExist(String id) {
			
			Optional<PMS> pms=repository.findById(id);
			
			if (pms.isPresent()) {
				return true;
				
			}
			else
			{
				return false;
			
				
			}
			
		}
		

	}



