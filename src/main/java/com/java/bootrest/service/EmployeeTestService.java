package com.java.bootrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.bootrest.entity.EmpyoeeTest;

@Service
public interface EmployeeTestService {

	EmpyoeeTest saveEmpyoeeTestDetails(EmpyoeeTest employee);

	List<EmpyoeeTest> findAllEmpyoeeTestDetails();

}
