package com.redhat.consulting.chmay.thorntailcdi.rest.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.redhat.consulting.chmay.thorntailcdi.rest.model.StatesCache;

import java.util.List;

@ApplicationScoped
@Path("/states")
public class StatesController {
	@Inject
	private StatesCache cache;

	@GET
	@Path("{state}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStateNameByCode(@PathParam("state") String stateCode) {
		return Response
				.ok(cache.getStateNameByCode(stateCode))
				.build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.ok(cache.getStates()).build();
	}
}
