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

import com.java.bootrest.entity.Company;
import com.java.bootrest.entity.Employee;
import com.java.bootrest.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/save")
	public ResponseEntity<Company> saveCompany(@RequestBody Company company){
		Company cmpny=companyService.saveCompanyDetails(company);
	return new ResponseEntity<Company>(cmpny,HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<Company> findAllCompanys(){
		List<Company> company=companyService.findAllCompanyDetails();
		return new ResponseEntity(company,HttpStatus.OK);
	}

}
