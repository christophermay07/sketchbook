package com.redhat.consulting.chmay.thorntailcdi.rest.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.redhat.consulting.chmay.thorntailcdi.rest.model.State;
import com.redhat.consulting.chmay.thorntailcdi.rest.model.StatesCache;
import com.redhat.consulting.chmay.thorntailcdi.rest.service.GreeterService;

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
		List<State> states = cache.getStates();

		// TODO: this is just awful, Chris; fix later!
		State state = states
				.stream()
				.filter(s -> s.getCode().equalsIgnoreCase(stateCode))
				.findFirst()
				.get();

		return Response
				.ok(state.getName())
				.build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.ok(cache.getStates()).build();
	}
}
