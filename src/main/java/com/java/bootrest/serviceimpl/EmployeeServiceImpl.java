package com.java.bootrest.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.bootrest.entity.Employee;
import com.java.bootrest.repository.EmployeeRepository;
import com.java.bootrest.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public Employee updateEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		 employeeRepository.delete(employee);
	}

	@Override
	public Employee findByEmpId(int empId) {
		// TODO Auto-generated method stub
		Employee emp= employeeRepository.findByEmpId(empId).get();
		return emp;
	}

	@Override
	public Employee findByEmpName(String empName) {
		Employee emp= employeeRepository.findByEmpName(empName);
		return emp;
	}

	@Override
	public Employee findByEmpNameAndEmpLocation(String empName,String location) {
		Employee emp= employeeRepository.findByEmpNameAndLocation(empName,location);
		return emp;
	}

	@Override
	public Employee findByEmpIdAndEmpDesgnation(int empId,String desgnation) {
		Employee emp= employeeRepository.findByEmpIdAndDesgnation(empId,desgnation);
		System.out.println(emp);
		return emp;
	}

	@Override
	public Employee findByEmpIdAndEmpNameAndLocation(int empId,String empName,String location) {
		Employee emp= employeeRepository.findByEmpIdAndEmpNameAndLocation(empId,empName,location);
		return emp;
	}

	@Override
	public List<Employee> sortingEmployeesByName() {
		// TODO Auto-generated method stub
	List<Employee>list=	employeeRepository.findAll();
	List<Employee> sortByNames= list.stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList());
		return sortByNames;
	}

	@Override
	public List<Employee> sortByEmployeeSalaries() {
		List<Employee>list=	employeeRepository.findAll();
		List<Employee> sortBySalaries = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList());
		return sortBySalaries;
	}

	@Override
	public Map<String, Long> occurenceEachCharacter() {
		List<Employee>list=	employeeRepository.findAll();
		List<String> myList=new ArrayList<String>();
		List<String> Names = list.stream().map(s1->s1.getEmpName()).collect(Collectors.toList());
		for(String str:Names) {
			if(str.contains("sreenivasarao")) {
				myList.add(str);	
			}
		}
		
		  String delim = ""; 
		  String str = String.join(delim, myList);
		  
		  Map<String, Long> occurence = Arrays.stream(str.split(""))
		  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		 		
		
		//Map<String, Long> stringOccurence = myList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		return occurence;
	}

	@Override
	public List<String> dublicateCharacterInStrings() {
	String str="sreenivasarao";
	List<String> dublicates = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
	.entrySet().stream().filter(s1->s1.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
		return dublicates;
	}

	@Override
	public List<String> uniqueElementsinString() {
		String str="sreenivasarao";
		List<String> uniqElements = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().filter(s1->s1.getValue()==1).map(Map.Entry::getKey).collect(Collectors.toList());
			return uniqElements;
	}

	@Override
	public String firstNonRepeatedCharacter() {
		String str="sreenivasarao";
		String firstnonRepeated = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
		.entrySet().stream().filter(s1->s1.getValue()==1).findFirst().get().getKey();
		return firstnonRepeated;
	}

	@Override
	public String firstRepeatedCharacter() {
		String str="sreenivasarao";
		String firstRepeated = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
		.entrySet().stream().filter(s1->s1.getValue()>1).findFirst().get().getKey();
		return firstRepeated;
	}

	@Override
	public String longestString() {
		List<Employee>list=	employeeRepository.findAll();
		List<String> Names = list.stream().map(s1->s1.getEmpName()).collect(Collectors.toList());
		String longestString = Names.stream().reduce((word1,word2)->word1.length()>word2.length()?word1:word2).get();
		return longestString;
	}

	@Override
	public List<String> startwithNumberforAge() {
		List<Employee> list = employeeRepository.findAll();
		List<Integer> ageList = list.stream().map(s1->s1.getAge()).collect(Collectors.toList());
		List<String> agesGiven = ageList.stream().map(s1->s1+"").filter(s2->s2.startsWith("3")).collect(Collectors.toList());
		return agesGiven;
	}

	@Override
	public String java8StringReverse() {
		String str="sreenivasarao";
		String stringReverse = Arrays.asList(str).stream()
	    .map(s -> new StringBuilder(s).reverse().toString())
	    .collect(Collectors.toList()).get(0);
		return stringReverse;
	}

	@Override
	public List<Employee> findAllEmployeeDetails() {
		List<Employee>list=	employeeRepository.findAll();
		return list;
	}

	@Override
	public Employee maxSalaryEmployee() {
		// TODO Auto-generated method stub
		List<Employee>list=	employeeRepository.findAll();
		Employee maxSalaryEmployee = list.stream().max(Comparator.comparingDouble(s1->s1.getSalary())).get();
		return maxSalaryEmployee;
	}

	@Override
	public Employee minSalaryEmployee() {
		List<Employee>list=	employeeRepository.findAll();
		Employee minSalaryEmployee = list.stream().min(Comparator.comparingDouble(s1->s1.getSalary())).get();
		return minSalaryEmployee;
	}

	@Override
	public Employee secondListSalaryEmployee() {
		List<Employee>list=	employeeRepository.findAll();
		Employee secondHigestSalary = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).skip(1).findFirst().get();
		return secondHigestSalary;
	}

	@Override
	public Employee secondHigestSalaryEmployee() {
		List<Employee>list=	employeeRepository.findAll();
		Employee secondHigestSalary = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst().get();
		return secondHigestSalary;
	}

	@Override
	public List<Employee> ascById() {
		List<Employee>list=	employeeRepository.findAll();
		List<Employee> ByIDAscSorted = list.stream().sorted(Comparator.comparing(Employee::getEmpId)).collect(Collectors.toList());
		return ByIDAscSorted;
	}

	@Override
	public List<Employee> dscById() {
		List<Employee>list=	employeeRepository.findAll();
		List<Employee> ByIdDscSorted = list.stream().sorted(Comparator.comparing(Employee::getEmpId).reversed()).collect(Collectors.toList());
		return ByIdDscSorted;
	}

	@Override
	public List<Employee> ascBySalaries() {
		List<Employee>list=	employeeRepository.findAll();
		List<Employee> ascSalarySorted = list.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		return ascSalarySorted;
	}

	@Override
	public List<Employee> dscBySalaries() {
		List<Employee>list=	employeeRepository.findAll();
		List<Employee> dscSalarySorted = list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		return dscSalarySorted;
	}

	@Override
	public List<Employee> ascByName() {
		List<Employee>list=	employeeRepository.findAll();
		List<Employee> ascNamesSorted = list.stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList());
		return ascNamesSorted;
	}

	@Override
	public List<Employee> dscByName() {
		List<Employee>list=	employeeRepository.findAll();
		List<Employee> dscNamesSorted = list.stream().sorted(Comparator.comparing(Employee::getEmpName).reversed()).collect(Collectors.toList());
		return dscNamesSorted;

	}

	@Override
	public Set<Employee> listToSetCoversion() {
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> set = list.stream().collect(Collectors.toSet());
		return set;
	}

	@Override
	public Map<Integer, Employee> listToMapCoversion() {
		List<Employee> list = employeeRepository.findAll();
		Map<Integer, Employee> listToMap = list.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
		return listToMap;
	}

	@Override
	public List<Employee> setToListCoversion() {
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> set = list.stream().collect(Collectors.toSet());
		System.out.println(set);
		List<Employee> setTolist = set.stream().collect(Collectors.toList());
		return setTolist;
	}

	@Override
	public Map<Integer, Employee> setToMapCoversion() {
		List<Employee> list = employeeRepository.findAll();
		Set<Employee> set = list.stream().collect(Collectors.toSet());
		Map<Integer, Employee> setToMapCoversion = set.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Function.identity()));

		return setToMapCoversion;	}

	@Override
	public List<Object> MapToListCoversion() {
		List<Employee> list = employeeRepository.findAll();
		Map<Integer, Employee> listToMap = list.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
		System.out.println(listToMap);
	List<Object> mapToListCoversion=listToMap.entrySet().stream().collect(Collectors.toList());
		return mapToListCoversion;
	}

	@Override
	public Set<Object> MapToSetCoversion() {
		List<Employee> list = employeeRepository.findAll();
		Map<Integer, Employee> listToMap = list.stream()
				.collect(Collectors.toMap(Employee::getEmpId, Function.identity()));
		System.out.println(listToMap);
	Set<Object> MapToSetCoversion=listToMap.entrySet().stream().collect(Collectors.toSet());
		return MapToSetCoversion;
	}

	@Override
	public List<Employee> evenEmpIds() {
		List<Employee> evenEmployeesList=employeeRepository.findAll();
		List<Employee> evenList= evenEmployeesList.stream().filter(s1->s1.getEmpId()%2==0).collect(Collectors.toList());
			return evenList;
	}

	@Override
	public List<Employee> oddEmpIds() {
		List<Employee> oddEmployeesList=employeeRepository.findAll();
		List<Employee> oddList= oddEmployeesList.stream().filter(s1->s1.getEmpId()%2!=0).collect(Collectors.toList());
			return oddList;
	}

	@Override
	public List<Employee> particularRecord() {
		List<Employee> list=employeeRepository.findAll();
		List<Employee> particularRecord=list.stream().skip(2).limit(1).collect(Collectors.toList());
		return particularRecord;
	}

	@Override
	public List<Employee> particularRecords() {
		List<Employee> list=employeeRepository.findAll();
		List<Employee> particularRecords=list.stream().skip(1).limit(3).collect(Collectors.toList());
		return particularRecords;
	}

	@Override
	public Set<Employee> printDublicates() {
		Set<Integer>set=new HashSet<Integer>();
		List<Employee> list=employeeRepository.findAll();
		Set<Employee> dublicates=list.stream().filter(s1-> !set.add(s1.getAge())).collect(Collectors.toSet());
		return dublicates;
	}

	@Override
	public Set<Employee> withoutDublicates() {
		Set<Integer>set=new HashSet<Integer>();
		List<Employee> list=employeeRepository.findAll();
		Set<Employee> withoutDublicates=list.stream().filter(s1-> set.add(s1.getAge())).collect(Collectors.toSet());
		return withoutDublicates;
	}

	@Override
	public List<Employee> subListDetails(int fromIndex, int toIndex) {
		List<Employee> list=employeeRepository.findAll();
		List<Employee> subList=list.subList(fromIndex, toIndex);
		return subList;
	}

	@Override
	public Map<Object, List<Employee>> groupByNames() {
		List<Employee> list=employeeRepository.findAll();
		Map<Object, List<Employee>> Names=list.stream().collect(Collectors.groupingBy(s1->s1.getEmpName(),Collectors.toList()));
		return Names;
	}

	@Override
	public Map<Object, List<Employee>> groupBySalaries() {
		List<Employee> list=employeeRepository.findAll();
		Map<Object, List<Employee>>Names=list.stream().collect(Collectors.groupingBy(s1->s1.getSalary(),TreeMap::new,Collectors.toList()));
		// TODO Auto-generated method stub
		return Names;
	}

	@Override
	public String joiningNames() {
		List<Employee> list=employeeRepository.findAll();
		String joining=list.stream().map(S1->S1.getEmpName()).collect(Collectors.joining(","));
		return joining;
	}

	
	

	
	}

