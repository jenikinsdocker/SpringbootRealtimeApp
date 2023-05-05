package com.java.bootrest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.bootrest.entity.EmpyoeeTest;
import com.java.bootrest.repository.EmployeeTestRepository;
import com.java.bootrest.service.EmployeeTestService;

@Component
public class EmployeeTestServiceImpl implements EmployeeTestService {
	
	@Autowired
	private EmployeeTestRepository employeeTestRepository;

	@Override
	public EmpyoeeTest saveEmpyoeeTestDetails(EmpyoeeTest employee) {
		// TODO Auto-generated method stub
		return employeeTestRepository.save(employee);
	}

	@Override
	public List<EmpyoeeTest> findAllEmpyoeeTestDetails() {
		// TODO Auto-generated method stub
		List<EmpyoeeTest> findAll = employeeTestRepository.findAll();
		return findAll;
	}

}
