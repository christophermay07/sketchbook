package com.redhat.consulting.chmay.thorntailcdi.rest.model;

import com.redhat.consulting.chmay.thorntailcdi.rest.model.reader.YamlReader;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

// TODO: Play with JSR-107, for funsies
@Singleton
public class StatesCache {
    private List<State> states;

    @PostConstruct
    public void init() {
        states = YamlReader.readFile("states.yaml", State.class);
    }

    public List<State> getStates() {
        return states;
    }
}

