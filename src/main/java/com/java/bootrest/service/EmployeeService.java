package com.java.bootrest.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.java.bootrest.entity.Employee;

@Service
public interface EmployeeService {
	
	public Employee saveEmployeeDetails(Employee employee);
	
	public Employee updateEmployeeDetails(Employee employee);
	
	public void deleteEmployeeDetails(Employee employee);
	
	public Employee findByEmpId(int empId);
	
	public Employee findByEmpName(String empName);
	
	public Employee findByEmpNameAndEmpLocation(String empName,String location);
	
	public Employee findByEmpIdAndEmpDesgnation(int empId,String desgnation);
	
	public Employee findByEmpIdAndEmpNameAndLocation(int empId,String empName,String location);
	
	public List<Employee> sortingEmployeesByName();
	
	public List<Employee> sortByEmployeeSalaries();
	
    public Map<String, Long> occurenceEachCharacter();
	
	public List<String> dublicateCharacterInStrings();
	
	public List<String> uniqueElementsinString();
	
	public String firstNonRepeatedCharacter();
	
	public String firstRepeatedCharacter();
	
	public String longestString();
	
	public List<String> startwithNumberforAge();
	
	public String java8StringReverse();

	public List<Employee> findAllEmployeeDetails();

	public Employee maxSalaryEmployee();

	public Employee minSalaryEmployee();

	public Employee secondListSalaryEmployee();

	public Employee secondHigestSalaryEmployee();

	public List<Employee> ascById();

	public List<Employee> dscById();

	public List<Employee> ascBySalaries();

	public List<Employee> dscBySalaries();

	public List<Employee> ascByName();

	public List<Employee> dscByName();
	
	public Set<Employee> listToSetCoversion();
	
	public Map<Integer, Employee> listToMapCoversion();
	
	public List<Employee> setToListCoversion();
	
	public Map<Integer, Employee> setToMapCoversion();
	
	public List<Object> MapToListCoversion();
	
	public Set<Object> MapToSetCoversion();
	
	public List<Employee> evenEmpIds();
	
	public List<Employee> oddEmpIds();
	
	public List<Employee> particularRecord();
	
	public List<Employee> particularRecords();
	
	public Set<Employee> printDublicates();
	
	public Set<Employee> withoutDublicates();
	
	public List<Employee> subListDetails(int fromIndex, int toIndex);
	
	public Map<Object, List<Employee>> groupByNames();
	
    public Map<Object, List<Employee>> groupBySalaries();
	
	public String joiningNames();

}
