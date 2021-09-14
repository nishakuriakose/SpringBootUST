package com.example.EMS_UST;

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
public class EMSController {
	


	AtomicInteger counter=new AtomicInteger();
	
	//counter=0;
	
	
	@Autowired
	EMSRepository repository;
	
	
	@Autowired
	EMSAddService emsservice; 
	
	@PostMapping("/addEmployee")
	public ResponseEntity<AddResponse> addEmp(@RequestBody EMS ems)
	{
	    HttpHeaders headers=new HttpHeaders();
		String id=ems.geteName()+counter.getAndIncrement();
		AddResponse add= new AddResponse();
		
		
		
		if(!emsservice.checkEMPAlreadyExist(id))
		{
				
		ems.seteID(id);
		repository.save(ems);
				
		
		//add.setId(ems.geteName()+counter.getAndIncrement());
		add.setId(id);
		add.setMsg(" Success : Employee is added");	
		headers.add("Unique", id);
		
		return new ResponseEntity<AddResponse>(add,headers,HttpStatus.CREATED);
		
		}
		
		else
		{
			ems.seteID(id);
			add.setMsg(" Employee is already Exists");	
			return new ResponseEntity<AddResponse>(add,headers,HttpStatus.ACCEPTED);
			
			
		}
	}
		
			@GetMapping("/getEmployee/{id}")
		
	       public EMS getEmployeeByID(@PathVariable(value="id")String id){
				
		    try
				
		    {
			EMS ems=repository.findById(id).get();
			return ems;
		    }
		   
		    catch(Exception e) {
				
			 throw new 	ResponseStatusException(HttpStatus.NOT_FOUND);
			
		    }
	      }
			
			
			@GetMapping("/getEmployee")
			public List<EMS> getEmployeeByName(@RequestParam(value="EmployeeName")String EmployeeName)
			{
			 
				return repository.FindAllByEmpName(EmployeeName);
				
				//repository.FindAllByEmpName(EmplyeeName);
						
			}
	
			
			@PutMapping("/updateEmployee/{id}")
			
			public ResponseEntity<EMS> UpdateEmployee(@PathVariable(value="id")String id,@RequestBody EMS ems)
			{
				
				EMS empRecord=repository.findById(id).get();
				empRecord.seteName(ems.geteName());
				empRecord.seteSAL(ems.geteSAL());
				
				repository.save(empRecord);
				return new ResponseEntity<EMS>(empRecord,HttpStatus.OK);
				
				
				
			}
			
			@DeleteMapping("/DeleteEmployee")
			
			public ResponseEntity<String> DeleteEmployee(@RequestBody EMS ems)
			{
			    EMS delID=repository.findById(ems.geteID()).get();
				repository.delete(delID);
				return new ResponseEntity<>("Employee record deleted",HttpStatus.CREATED);
				
					
			}
			
			
			
			@DeleteMapping("deleteAll")
			public  ResponseEntity<String> DeleteAllEmployee(){
				repository.deleteAll();
				return new ResponseEntity<>("Employee record deleted",HttpStatus.CREATED);
				
			}
			
	}
	
	
	
	
	
	
	


