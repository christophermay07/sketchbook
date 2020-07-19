package com.redhat.consulting.chmay.thorntailcdi.rest.service;

public class HelloWorldService implements GreeterService {

	@Override
	public String sayHello() {
		return "Hello World!";
	}
}
