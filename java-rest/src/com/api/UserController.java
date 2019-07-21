package com.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")
public class UserController {

	@Path("all")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getUsers() {

		return "Sample data";
	}
}
