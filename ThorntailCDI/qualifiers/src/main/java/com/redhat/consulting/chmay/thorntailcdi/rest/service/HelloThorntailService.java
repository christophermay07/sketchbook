package com.redhat.consulting.chmay.thorntailcdi.rest.service;

import com.redhat.consulting.chmay.thorntailcdi.rest.annotation.ServerSpecific;

@ServerSpecific
public class HelloThorntailService implements GreeterService {

	@Override
	public String sayHello() {
		return "Hello from Thorntail!";
	}
}
