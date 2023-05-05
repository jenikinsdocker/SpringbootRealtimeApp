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

import com.java.bootrest.entity.Student;
import com.java.bootrest.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		Student students=studentService.saveStudentDetails(student);
	return new ResponseEntity<Student>(students,HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<Student> findAllEmployees(){
		List<Student> student=studentService.findAllEmployeeDetails();
		return new ResponseEntity(student,HttpStatus.OK);
	}

}
