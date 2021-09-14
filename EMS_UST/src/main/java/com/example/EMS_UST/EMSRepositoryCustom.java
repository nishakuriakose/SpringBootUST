package com.example.EMS_UST;

import java.util.List;



public interface EMSRepositoryCustom {
	
	List<EMS> FindAllByEmpName(String EmployeeName);
}
