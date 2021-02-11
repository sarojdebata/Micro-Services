package com.sd.spring.add.file.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.spring.add.file.pojo.ADDEmployee;

@Repository
public class ADDDao {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public void saveTransaction(List<ADDEmployee> addEmployees) {
			employeeRepository.saveAll(addEmployees);
	}

}
