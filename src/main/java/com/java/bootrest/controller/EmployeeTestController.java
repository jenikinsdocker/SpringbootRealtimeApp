package com.java.bootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.bootrest.entity.Employee;
import com.java.bootrest.entity.EmpyoeeTest;
import com.java.bootrest.service.EmployeeTestService;

@RestController
@RequestMapping("/employeetest")
public class EmployeeTestController {
	
	@Autowired
	private EmployeeTestService employeeTestService;
	
	
	@PostMapping("/save")
	public ResponseEntity<EmpyoeeTest> saveEmployee(@RequestBody EmpyoeeTest employee){
	EmpyoeeTest emp=employeeTestService.saveEmpyoeeTestDetails(employee);
	return new ResponseEntity<EmpyoeeTest>(emp,HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<EmpyoeeTest> findAllEmpyoeeTest(){
		List<EmpyoeeTest> employee=employeeTestService.findAllEmpyoeeTestDetails();
		return new ResponseEntity(employee,HttpStatus.OK);
	}

}
