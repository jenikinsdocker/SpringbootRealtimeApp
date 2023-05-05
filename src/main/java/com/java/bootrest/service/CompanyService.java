package com.java.bootrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.bootrest.entity.Company;

@Service
public interface CompanyService {

	Company saveCompanyDetails(Company company);

	List<Company> findAllCompanyDetails();

}
