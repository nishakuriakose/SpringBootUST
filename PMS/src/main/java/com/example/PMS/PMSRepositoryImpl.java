package com.example.PMS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class PMSRepositoryImpl implements PMSRepositoryCustom {








	
	@Autowired
	PMSRepository repository;

	@Override
	public List<PMS> FindAllByPizzaName(String pName) {
		
		
		List<PMS> pNames=new ArrayList<PMS>();
		List<PMS> pmps=repository.findAll();
		
		for (PMS items:pmps)
		{
				if (items.getpNAME().equalsIgnoreCase(pName))
					{
					pNames.add(items);
					}
		}
		
		return pNames;
	}

	
	}
	

