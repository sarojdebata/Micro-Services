package com.sd.spring.add.file.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.spring.add.file.handler.ADDFileHandler;
import com.sd.spring.add.file.pojo.ADDEmployee;

@RestController
@RequestMapping(value = "/rest/file")
public class ADDFileProcessingController {

	@Autowired
	private ADDFileHandler addFileHandler;
	
	
	@PostMapping("/add")
	public boolean processADDFile() throws IOException{
		try (BufferedReader br = new BufferedReader(new FileReader("D:\\FileToTest\\input.txt")) ){
			List<ADDEmployee> addEmployees = new ArrayList<>();
			String line = br.readLine();
			while(null != line) {
				String[] arr = line.split(",");
				ADDEmployee emp = new ADDEmployee();
 				for (int i = 0; i < arr.length; i++) {
					if("0".equals(String.valueOf(i))) {
						emp.setName(arr[i]);
					}else if("1".equals(String.valueOf(i))) {
						emp.setAge(Integer.parseInt(arr[i]));
					}else if("2".equals(String.valueOf(i))) {
						emp.setSalary(Integer.parseInt(arr[i]));
					}else if("3".equals(String.valueOf(i))) {
						emp.setDob(getDateofBirth(arr[i]));
					}
 				}
 				addEmployees.add(emp);
 				line = br.readLine();
			}
			
			addFileHandler.processRecordSpec(addEmployees);
		
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the mentiond Direcotory ::"+e.getMessage());
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	private Date getDateofBirth(String str) {
		Date date = new Date(str);
		return date;
	}
	
}
