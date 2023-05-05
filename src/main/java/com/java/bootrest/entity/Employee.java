package com.java.bootrest.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
public class Employee {
	@Id
	private int empId;
	private String empName;
	private int age;
	private double salary;
	private String location;
	private String desgnation;
	private String platform;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "Employee_Company",joinColumns = {@JoinColumn(name = "emp_Id", referencedColumnName = "empId")}, inverseJoinColumns = {
    @JoinColumn(name = "company_Id", referencedColumnName = "companyId") })
	private List<Company> companies;
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDesgnation() {
		return desgnation;
	}
	public void setDesgnation(String desgnation) {
		this.desgnation = desgnation;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	public List<Company> getCompanies() {
		return companies;
	}

}
