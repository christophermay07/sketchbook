package com.redhat.consulting.chmay.thorntailcdi.rest.service;

import com.redhat.consulting.chmay.thorntailcdi.rest.annotation.Nice;

import javax.enterprise.context.Dependent;

@Nice
public class NiceGreeterService extends GreeterService implements I_GreeterService {
	@Override
	protected String getSalutation() {
		return "Nice to see you";
	}
}
