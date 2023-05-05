package com.java.bootrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.bootrest.entity.Student;

@Service
public interface StudentService {

	Student saveStudentDetails(Student student);

	List<Student> findAllEmployeeDetails();

}
