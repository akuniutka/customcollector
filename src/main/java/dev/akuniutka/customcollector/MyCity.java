package dev.akuniutka.customcollector;

import java.util.ArrayList;
import java.util.List;

public class MyCity {
    private final String name;
    private final List<MyPerson> persons;

    public MyCity(String name) {
        this.name = name;
        this.persons = new ArrayList<>();
    }

    public void addPerson(MyPerson person) {
        persons.add(person);
    }

    public MyCity merge(MyCity city) {
        persons.addAll(city.persons);
        return this;
    }

    public MyCity print() {
        System.out.println(": " + name);
        for (MyPerson person : persons) {
            System.out.println("\t" + person.getFirstName() + " " + person.getLastName());
        }
        return this;
    }
}
