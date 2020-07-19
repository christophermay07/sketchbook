package com.redhat.consulting.chmay.thorntailcdi.rest.service;

import com.redhat.consulting.chmay.thorntailcdi.rest.name.NameService;

import javax.inject.Inject;

public abstract class GreeterService implements I_GreeterService {
    @Inject
    private NameService svc;

    public String greet() {
        return greet(svc.getDefaultName());
    }

    public String greet(String name) {
        return getSalutation() +", " + name + "!";
    }

    protected abstract String getSalutation();
}
