package com.example.PMS;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PMSRepository  extends JpaRepository<PMS,String>,PMSRepositoryCustom


{

}
