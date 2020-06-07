package com.java.assignment;

import java.util.Objects;

public class Person {
    /*
    * id|firstName|lastName
    * */

    int id;
    String firstName;
    String lastName;

    public Person(int id){
        this.id = id;
    }
    public Person(int id, String firstName, String lastName){
        this(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId() &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), firstName, lastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
