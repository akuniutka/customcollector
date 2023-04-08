package dev.akuniutka.customcollector;

public class MyPerson {
    private final String firstName;
    private final String lastName;

    public MyPerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
