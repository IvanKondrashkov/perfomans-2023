package ru.kondrashkov.prototype

class Person {
    String firstName
    String lastName
    int age
    Double salary
    Address address

    Person(String firstName, String lastName, int age, Double salary, Address address) {
        this.firstName = firstName
        this.lastName = lastName
        this.age = age
        this.salary = salary
        this.address = address
    }

    Person(Person person) {
        this.firstName = person.firstName
        this.lastName = person.lastName
        this.age = person.age
        this.salary = person.salary
        this.address = new Address(person.address)
    }
}