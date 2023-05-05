package com.java.bootrest.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.bootrest.entity.Employee;
import com.java.bootrest.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
	Employee emp=employeeService.saveEmployeeDetails(employee);
	return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
	Employee emp=employeeService.updateEmployeeDetails(employee);
	return new ResponseEntity<Employee>(emp,HttpStatus.NO_CONTENT);
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/delete")
	public ResponseEntity<Employee> deleteEmployee(@RequestBody Employee employee){
	employeeService.deleteEmployeeDetails(employee);
	return new ResponseEntity("Sucessfully Deleted from DB..",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/byId/{empId}")
	public ResponseEntity<Employee> findById(@PathVariable("empId") int empId){
		Employee employee=employeeService.findByEmpId(empId);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/byName")
	public ResponseEntity<Employee> findByName(@RequestParam(name ="name") String empName){
		Employee employee=employeeService.findByEmpName(empName);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}

	@GetMapping("/findAll")
	public ResponseEntity<Employee> findAllEmployees(){
		List<Employee> employee=employeeService.findAllEmployeeDetails();
		return new ResponseEntity(employee,HttpStatus.OK);
	}
	
	@GetMapping("/byNameAndLocation/{empName}/{location}")
	public ResponseEntity<Employee> findByEmpNameAndEmpLocation(@PathVariable("empName")String empName,@PathVariable("location")String location){
		Employee employee=employeeService.findByEmpNameAndEmpLocation(empName,location);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/byIdAndDesignation/{empId}/{desgnation}")
	public ResponseEntity<Employee> findByEmpIdAndDesgnation(@PathVariable("empId")int empId,@PathVariable("desgnation")String desgnation){
		Employee employee=employeeService.findByEmpIdAndEmpDesgnation(empId,desgnation);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/byIdAndNameAndLocation/{empId}/{empName}/{location}")
	public ResponseEntity<Employee> findByEmpIdAndEmpNameAndLocation(@PathVariable("empId")int empId,@PathVariable("empName")String empName,@PathVariable("location")String location){
		Employee employee=employeeService.findByEmpIdAndEmpNameAndLocation(empId,empName,location);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	@GetMapping("/sortingEmployeesByName")
	public ResponseEntity<Employee> sortingEmployeesByName(){
		List<Employee> employee=employeeService.sortingEmployeesByName();
		return new ResponseEntity(employee,HttpStatus.OK);
}
	
	@GetMapping("/sortByEmployeeSalaries")
	public ResponseEntity<Employee> sortByEmployeeSalaries(){
		List<Employee> employee=employeeService.sortByEmployeeSalaries();
		return new ResponseEntity(employee,HttpStatus.OK);
}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/occurence")
	public ResponseEntity<String> getOcuurenceOfString() {
	Map<String, Long> str=	employeeService.occurenceEachCharacter();
	return new ResponseEntity(str,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/dublicates")
	public ResponseEntity<String> getdublicateselementsinString() {
    List<String> dublicateelemts = employeeService.dublicateCharacterInStrings();
    System.out.println(dublicateelemts);
	return new ResponseEntity(dublicateelemts,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/uniqueElements")
	public ResponseEntity<String> uniquesElementsInString() {
    List<String> uniqueElements = employeeService.uniqueElementsinString();
    System.out.println(uniqueElements);
	return new ResponseEntity(uniqueElements,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/nonRepeatedCharacter")
	public ResponseEntity<String> nonRepeatedCharacterInString() {
    String nonRepeatedCharacter = employeeService.firstNonRepeatedCharacter();
    System.out.println(nonRepeatedCharacter);
	return new ResponseEntity(nonRepeatedCharacter,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/RepeatedCharacter")
	public ResponseEntity<String> RepeatedCharacterInString() {
    String RepeatedCharacter = employeeService.firstRepeatedCharacter();
    System.out.println(RepeatedCharacter);
	return new ResponseEntity(RepeatedCharacter,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/longestString")
	public ResponseEntity<String> longestString() {
    String longestString = employeeService.longestString();
    System.out.println(longestString);
	return new ResponseEntity(longestString,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/filterAges")
	public ResponseEntity<String> filterAges() {
    List<String> filterAges = employeeService.startwithNumberforAge();
    System.out.println(filterAges);
	return new ResponseEntity(filterAges,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/stringReverse")
	public ResponseEntity<String> stringReverse() {
    String stringReverse = employeeService.java8StringReverse();
    System.out.println(stringReverse);
	return new ResponseEntity(stringReverse,HttpStatus.OK);
	}
	

	@GetMapping("/maxSalary")
	public ResponseEntity<Employee> findMaxSalary(){
		Employee maxSalary=employeeService.maxSalaryEmployee();
		return new ResponseEntity<Employee>(maxSalary,HttpStatus.OK);
	}
	@GetMapping("/minSalary")
	public ResponseEntity<Employee> findMinSalary(){
		Employee minSalary=employeeService.minSalaryEmployee();
		return new ResponseEntity<Employee>(minSalary,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/secondListSalaryEmployee")
	public ResponseEntity<Employee> secondListSalaryEmployee(){
		Employee secondHigestSalary=employeeService.secondListSalaryEmployee();
		return new ResponseEntity(secondHigestSalary,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/secondHigestSalary")
	public ResponseEntity<Employee> secondHigestSalary(){
		Employee secondHigestSalary=employeeService.secondHigestSalaryEmployee();
		return new ResponseEntity(secondHigestSalary,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/ascBySalary")
	public ResponseEntity<Employee> ascBySalary(){
		List<Employee> ascBySalary=employeeService.ascBySalaries();
		return new ResponseEntity(ascBySalary,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/dscBySalary")
	public ResponseEntity<Employee> dscBySalary(){
		List<Employee> dscBySalary=employeeService.dscBySalaries();
		return new ResponseEntity(dscBySalary,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/ascByNames")
	public ResponseEntity<Employee> ascByNames(){
		List<Employee> ascByNames=employeeService.ascByName();
		return new ResponseEntity(ascByNames,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/dscByNames")
	public ResponseEntity<Employee> dscByNames(){
		List<Employee> dscByNames=employeeService.dscByName();
		return new ResponseEntity(dscByNames,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/ascById")
	public ResponseEntity<Employee> ascById(){
		List<Employee> ascById=employeeService.ascById();
		return new ResponseEntity(ascById,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/dscById")
	public ResponseEntity<Employee> dscById(){
		List<Employee> dscById=employeeService.dscById();
		return new ResponseEntity(dscById,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/listToSetConversion")
	public ResponseEntity<Employee> listToSetConversion(){
		Set<Employee> listToSetConversion=employeeService.listToSetCoversion();
		return new ResponseEntity(listToSetConversion,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/listToMapConversion")
	public ResponseEntity<Employee> listToMapConversion(){
		Map<Integer,Employee> listToMapConversion=employeeService.listToMapCoversion();
		return new ResponseEntity(listToMapConversion,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/SetToListConversion")
	public ResponseEntity<Employee> SetToListConversion(){
		List<Employee> SetToListConversion=employeeService.setToListCoversion();
		return new ResponseEntity(SetToListConversion,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/SetToMapConversion")
	public ResponseEntity<Employee> SetToMapConversion(){
		Map<Integer,Employee> SetToMapConversion=employeeService.setToMapCoversion();
		return new ResponseEntity(SetToMapConversion,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/MapToListConversion")
	public ResponseEntity<Employee> MapToListConversion(){
		List<Object> MapToListConversion=employeeService.MapToListCoversion();
		return new ResponseEntity(MapToListConversion,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/MapToSetConversion")
	public ResponseEntity<Employee> MapToSetConversion(){
		Set<Object> MapToSetConversion=employeeService.MapToSetCoversion();
		return new ResponseEntity(MapToSetConversion,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/evenEmpIds")
	public ResponseEntity<Employee> evenEmployeeIdData(){
		List<Employee> evenList=employeeService.evenEmpIds();
		return new ResponseEntity( evenList,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/oddEmpIds")
	public ResponseEntity<Employee> oddEmployeeIdData(){
		List<Employee> oddEmpIds=employeeService.oddEmpIds();
		return new ResponseEntity( oddEmpIds,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/particularRecord")
	public ResponseEntity<Employee> particularRecord(){
		List<Employee> particularRecord=employeeService.particularRecord();
		return new ResponseEntity( particularRecord,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/particularRecords")
	public ResponseEntity<Employee> particularRecords(){
		List<Employee> particularRecords=employeeService.particularRecords();
		return new ResponseEntity( particularRecords,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/printDublicatesEmployeeList")
	public ResponseEntity<Employee> printDublicates(){
		Set<Employee> printDublicates=employeeService.printDublicates();
		return new ResponseEntity( printDublicates,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/withoutDublicatesEmployeeList")
	public ResponseEntity<Employee> withoutDublicates(){
		Set<Employee> withoutDublicates=employeeService.withoutDublicates();
		return new ResponseEntity( withoutDublicates,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/rangeList/{fromIndex},{toIndex}")
	public ResponseEntity<Employee> rangeList(@PathVariable("fromIndex") int fromIndex,@PathVariable("toIndex") int toIndex){
		List<Employee> rangeList=employeeService.subListDetails(fromIndex, toIndex);
		return new ResponseEntity( rangeList,HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/groupByNames")
	public ResponseEntity<Employee> groupByNames(){
		Map<Object, List<Employee>> groupByNames=employeeService.groupByNames();
		return new ResponseEntity( groupByNames,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/groupBySalaries")
	public ResponseEntity<Employee> groupBySalaries(){
		Map<Object, List<Employee>> groupBySalaries=employeeService.groupBySalaries();
		return new ResponseEntity( groupBySalaries,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/joinedNames")
	public ResponseEntity<Employee> joinedNames(){
		String joinedNames=employeeService.joiningNames();
		return new ResponseEntity( joinedNames,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}