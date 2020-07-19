package com.redhat.consulting.chmay.thorntailcdi.rest.name;

import com.redhat.consulting.chmay.thorntailcdi.rest.service.GreeterService;

import javax.enterprise.context.Dependent;

public class NameService {
	public String getDefaultName() {
		return "Anonymous";
	}
}
