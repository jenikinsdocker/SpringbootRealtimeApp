package com.java.bootrest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.java.bootrest.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Optional<Employee> findByEmpId(int empId);

	Employee findByEmpName(String empName);
	
     @Query("SELECT e FROM Employee e WHERE e.empName=:empName and e.location=:location")
	Employee findByEmpNameAndLocation(@Param("empName") String empName,@Param("location") String location);
    
    //@Query("SELECT e.emp_Id,e.desgnation FROM springbootrealtime.Employee e where e.emp_Id =emp_Id")
    @Query(value="SELECT e FROM Employee e WHERE e.empId=:empId and e.desgnation=:desgnation")
	Employee findByEmpIdAndDesgnation(@Param("empId")int empId,@Param("desgnation")String desgnation);

    @Query("SELECT e FROM Employee e WHERE e.empId=:empId and e.empName=:empName and e.location=:location")
	Employee findByEmpIdAndEmpNameAndLocation(@Param("empId")int empId, @Param("empName")String empName, @Param("location")String location);

	//@Query("SELECT p FROM Address p WHERE p.addressLine1 =:addressLine1 and p.postcode=:postcode")
   // List<Address> findByAddressLine1AndPost(@Param("addressLine1") String addressLine1, @Param("postcode") String postcode);

}
