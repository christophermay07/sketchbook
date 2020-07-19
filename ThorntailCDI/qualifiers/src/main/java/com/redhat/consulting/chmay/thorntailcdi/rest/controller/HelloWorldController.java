package com.redhat.consulting.chmay.thorntailcdi.rest.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.redhat.consulting.chmay.thorntailcdi.rest.service.GreeterService;

@ApplicationScoped
@Path("")
public class HelloWorldController {

	@Inject
	GreeterService svc;

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok(svc.sayHello()).build();
	}
}
