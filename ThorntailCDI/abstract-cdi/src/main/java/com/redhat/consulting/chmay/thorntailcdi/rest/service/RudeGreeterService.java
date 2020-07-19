package com.redhat.consulting.chmay.thorntailcdi.rest.service;

import com.redhat.consulting.chmay.thorntailcdi.rest.annotation.Rude;

import javax.enterprise.context.Dependent;

@Rude
public class RudeGreeterService extends GreeterService implements I_GreeterService {
	@Override
	protected String getSalutation() {
		return "Oh, not you again";
	}
}
