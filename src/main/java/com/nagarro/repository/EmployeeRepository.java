package com.nagarro.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nagarro.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// Query to update employee details
	@Modifying
	@Query("update  Employee set empName=?2 , empLocation=?3 , empEmail=?4 , empDOB=?5 where empCode=?1")
	void updateEmployee(long empId, String empName, String empLoc, String empEmail, Date dob);

}
