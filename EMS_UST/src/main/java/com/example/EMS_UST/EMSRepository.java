package com.example.EMS_UST;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface EMSRepository extends JpaRepository<EMS,String>, EMSRepositoryCustom 
{
	
	 


}
