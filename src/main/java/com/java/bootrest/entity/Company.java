package com.java.bootrest.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table(name = "CompanyTest")
public class Company {
	@Id
	private int companyId;
	private String name;
	private String location;
	@ManyToMany(mappedBy = "companies",fetch = FetchType.LAZY)
	@JsonBackReference
	private List<EmpyoeeTest> employeetest;
	
	public List<EmpyoeeTest> getEmployeetest() {
		return employeetest;
	}
	public void setEmployeetest(List<EmpyoeeTest> employeetest) {
		this.employeetest = employeetest;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
