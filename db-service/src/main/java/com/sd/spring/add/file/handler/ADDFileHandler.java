package com.sd.spring.add.file.handler;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.spring.add.file.dao.ADDDao;
import com.sd.spring.add.file.pojo.ADDEmployee;

@Service
public class ADDFileHandler {

	@Autowired
	ADDDao addDao;
	
	
	public void processRecordSpec(List<ADDEmployee> addEmployees) throws IOException {
			addDao.saveTransaction(addEmployees);
	}
	
	
}
