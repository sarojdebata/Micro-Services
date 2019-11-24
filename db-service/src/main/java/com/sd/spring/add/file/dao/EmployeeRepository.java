package com.sd.spring.add.file.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sd.spring.add.file.pojo.ADDEmployee;

@Repository
public interface EmployeeRepository extends JpaRepository<ADDEmployee, Long>{
	
}
