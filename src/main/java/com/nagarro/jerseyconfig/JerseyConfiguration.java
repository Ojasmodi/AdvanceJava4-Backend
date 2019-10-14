package com.nagarro.jerseyconfig;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.nagarro.controller.EmployeeController;
import com.nagarro.controller.UserController;

@Component
@ApplicationPath("/api/v1")
public class JerseyConfiguration extends ResourceConfig {

	
	// adding the classes which will be needed for api request
	public JerseyConfiguration() {
		register(UserController.class);
		register(EmployeeController.class);
		register(CORSResponseFilter.class);
	}
}