package com.java.bootrest.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.bootrest.entity.Student;
import com.java.bootrest.repository.StudentRepository;
import com.java.bootrest.service.StudentService;

@Component
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public List<Student> findAllEmployeeDetails() {
		List<Student> list = studentRepository.findAll();
		return list;
	}

}
