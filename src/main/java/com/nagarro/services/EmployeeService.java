package com.nagarro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.models.Employee;
import com.nagarro.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	Employee employee;

	@Autowired
	EmployeeRepository employeeRepository;

	// method to save employee
	public Employee saveEmployee(Employee emp) throws Exception {
		employee = employeeRepository.save(emp);
		return employee;

	}

	//method to update employee details
	@Transactional
	public boolean updateEmployee(Employee emp, String empId) {
		try {
			long employeeId=Long.parseLong(empId);
			employeeRepository.updateEmployee(employeeId, emp.getEmpName(), emp.getEmpLocation(), emp.getEmpEmail(),emp.getEmpDOB());
			return true;
		}
		catch(Exception e) {
			return false;	
		}
	}

	// method to get all employees
	public List<Employee> getAllEmployees() throws Exception {
		return employeeRepository.findAll();
	}

	// method to get employee by ID/empCode
	public Employee getEmployeeById(String empId) 
	{
		try {
			long employeeId=Long.parseLong(empId);
			Employee employee=employeeRepository.findById(employeeId).orElse(null);
			return employee;
		}
		catch(Exception e) {
			return null;
		}
	}

}
