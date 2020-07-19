package com.redhat.consulting.chmay.thorntailcdi.rest.model;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.redhat.consulting.chmay.thorntailcdi.rest.service.GreeterService;

public class State {
	private String code;
	private String name;

	public State() {
		this(null, null);
	}

	public State(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public State(Object stateObj) {
		if (stateObj instanceof State) {
			State state = (State) stateObj;
			this.code = state.getCode();
			this.name = state.getName();
		} else
			throw new IllegalArgumentException("Expected state, but received " + stateObj.getClass());
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
