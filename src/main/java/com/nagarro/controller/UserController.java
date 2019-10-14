package com.nagarro.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.models.User;
import com.nagarro.services.UserService;

@Path("/users")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	User user;

	// /api/v1/users/login
	// method:POST
	// Parameters: username:String and password:String as body params
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login")
	public Response loginUser(User user) throws Exception  {

		user = userService.authenticateUser(user.getUsername(), user.getPassword());
		if (user == null) {
			return Response.status(Status.OK).entity(null).build();
		}
		return Response.status(Status.OK).entity(user).build();
	}
	

}
