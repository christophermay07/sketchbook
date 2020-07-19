package com.redhat.consulting.chmay.thorntailcdi.rest.controller;

import com.redhat.consulting.chmay.thorntailcdi.rest.annotation.Nice;
import com.redhat.consulting.chmay.thorntailcdi.rest.annotation.Rude;
import com.redhat.consulting.chmay.thorntailcdi.rest.service.GreeterService;
import com.redhat.consulting.chmay.thorntailcdi.rest.service.I_GreeterService;
import com.redhat.consulting.chmay.thorntailcdi.rest.service.NiceGreeterService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/hello")
public class HelloWorldController {

	// TODO: what happens w/ final? static? both?
	@Inject
	@Nice
	private NiceGreeterService svc;

	@GET
	@Produces("text/plain")
	public Response greet() {
		return Response.ok(svc.greet()).build();
	}

	@GET
	@Path("/{name}")
	@Produces("text/plain")
	public Response greet(@PathParam("name") String name) {
		return Response.ok(svc.greet(name)).build();
	}
}
