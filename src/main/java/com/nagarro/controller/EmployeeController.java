package com.nagarro.controller;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.models.Employee;
import com.nagarro.services.EmployeeService;

@Path("/employee")
public class EmployeeController {

	@Autowired
	Employee employee;

	@Autowired
	EmployeeService employeeService;

	// /api/v1/employee/all
	// method:GET
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployees() throws Exception {

		List<Employee> employees = employeeService.getAllEmployees();
		if (employees.isEmpty()) {
			return Response.status(Status.OK).entity(null).build();
		}
		return Response.status(Status.OK).entity(new GenericEntity<List<Employee>>(employees) {
		}).build();
	}

	// /api/v1/employee/get/id
	// method:GET
	// params:empId as id as a URL parameter
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeByCode(@PathParam("id") String empId) throws ParseException {

		Employee employee = employeeService.getEmployeeById(empId);
		return Response.status(Status.OK).entity(employee).build();
	}
	

	// /api/v1/employee/add
	// method: POST
	// params: employee data as body params
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee emp) throws Exception {

		employee = employeeService.saveEmployee(emp);
		return Response.status(Status.OK).entity(employee).build();
	}
	

	// /api/v1/employee/update/123
	// method: PUT
	// params: id as URL parameter and employee data as JSON data
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(Employee emp, @PathParam("id") String empId) throws ParseException {

		if (employeeService.updateEmployee(emp, empId)) {
			return Response.status(Status.OK).entity(null).build();
		}
		else {
			return Response.status(Status.OK).entity(employee).build();
		}
		
	}

}
