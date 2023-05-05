package com.java.bootrest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.bootrest.entity.Company;
import com.java.bootrest.repository.CompanyRepository;
import com.java.bootrest.service.CompanyService;

@Component
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company saveCompanyDetails(Company company) {
		// TODO Auto-generated method stub
		return companyRepository.save(company);
	}

	@Override
	public List<Company> findAllCompanyDetails() {
		// TODO Auto-generated method stub
		List<Company> findAll = companyRepository.findAll();
		return findAll;
	}

}
