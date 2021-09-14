package com.example.PMS;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;




@RestController
public class PMSController {
	
	
	AtomicInteger counter=new AtomicInteger();
	
	@Autowired
	PMSAddService pmsservice; 
	
	@Autowired
	PMSRepository repository;
	
	
	@PostMapping("/addpizza")
	public ResponseEntity<AddResponse> addPizzaImplementation(@RequestBody PMS pms)
	
	{
		
		HttpHeaders headers=new HttpHeaders();
		String id=(pms.getpNAME()+ counter.getAndIncrement());//--> Concat not working
		AddResponse add= new AddResponse();
		pms.setpID(id);
		
		if(!pmsservice.checkPMSAlreadyExist(id))
		{
				
		//pms.setpID("Veggie001");
			
		pms.setpID(id);
		repository.save(pms);
				
		
		//add.setId(ems.geteName()+counter.getAndIncrement());
		add.setId(id);
		add.setMsg(" Success : Pizza is added");	
		headers.add("Unique", id);
		
		return new ResponseEntity<AddResponse>(add,headers,HttpStatus.CREATED);
		
		}
		
		else
		{
			pms.setpID(id);
			add.setMsg(" Pizza is already Exists");	
			return new ResponseEntity<AddResponse>(add,headers,HttpStatus.ACCEPTED);
			
			
			
			/*
			 * ems.seteID(id);
			add.setMsg(" Employee is already Exists");	
			return new ResponseEntity<AddResponse>(add,headers,HttpStatus.ACCEPTED);
			
			 */
		}
	}

	
	

	@GetMapping("/getpizza/{id}")

   public PMS getPizzaByID(@PathVariable(value="id")String id){
		
   try
		
    {
	  PMS pms=repository.findById(id).get();
	  return pms;
    }
   
   catch(Exception e) {
		
	   throw new 	ResponseStatusException(HttpStatus.NOT_FOUND);
	
  
    }
	}
	
	@PutMapping("/updatePizza/{id}")
			
			public ResponseEntity<PMS> UpdatePizza(@PathVariable(value="id")String id,@RequestBody PMS pms)
			{
				
				PMS pmpRecord=repository.findById(id).get();
				
				pmpRecord.setpNAME(pms.getpNAME());
	
				pmpRecord.setpPRICE(pms.getpPRICE());
				repository.save(pmpRecord);
				return new ResponseEntity<PMS>(pmpRecord,HttpStatus.OK);
				
				
				
			}
	

	@GetMapping("/getPizza")
	public List<PMS> getPizaaByPizzaName(@RequestParam(value="Product")String Product)
	{
	 
		return repository.FindAllByPizzaName(Product);
		


	}
	
	
	
	
			
		     @DeleteMapping("/deletepizza")
			
			public ResponseEntity<String> deletepizza(@RequestBody PMS pms)
			{
			    PMS delID=repository.findById(pms.getpID()).get();
				repository.delete(delID);
				return new ResponseEntity<>("Pizza record deleted",HttpStatus.CREATED);
				
					
			}
			
			
	
	
	
			
			@DeleteMapping("deleteAll")
			  public  ResponseEntity<String> DeleteAllPizaa(){
				repository.deleteAll();
				return new ResponseEntity<>("All Pizza records deleted",HttpStatus.CREATED);
				
			}


	}
	
	



