package com.java.bootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.bootrest.entity.EmpyoeeTest;

@Repository
public interface EmployeeTestRepository extends JpaRepository<EmpyoeeTest, Integer> {

}
