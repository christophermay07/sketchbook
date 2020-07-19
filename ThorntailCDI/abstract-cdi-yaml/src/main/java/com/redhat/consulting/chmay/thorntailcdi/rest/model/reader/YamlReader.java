package com.redhat.consulting.chmay.thorntailcdi.rest.model.reader;

import com.redhat.consulting.chmay.thorntailcdi.rest.model.State;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import javax.enterprise.context.Dependent;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Dependent
public class YamlReader {
    // TODO: Doing the generics thing was a pain for SnakeYaml, so doing it the bad way for now (below)
    public static <T> List<T> readFile(String filename, Class<T> clazz) {
        Yaml yaml = new Yaml(new Constructor(clazz));
        try (InputStream is = YamlReader.class.getClassLoader().getResourceAsStream(filename)) {

        }

        return StreamSupport.stream(yaml.loadAll(inputStream).spliterator(), false)
                .map(s -> (T) s)
                .collect(Collectors.toList());
    }

    public static State List<State> readStatesFile(String filename) {
        Yaml yaml = new Yaml();
        try (InputStream in = LoadAsJavaObject.class.getResourceAsStream("/persons.yml")) {
            Persons persons = yaml.loadAs(in, Persons.class);
            for (Person person : persons.getPersons()) {
                System.out.println(person);
            }
        }

        Yaml yaml = new Yaml(new Constructor(State.class));
        InputStream inputStream = YamlReader.class
                .getClassLoader()
                .getResourceAsStream(filename);

        return StreamSupport.stream(yaml.loadAll(inputStream).spliterator(), false)
                .map(s -> new State(s))
                .collect(Collectors.toList());
    }
}
