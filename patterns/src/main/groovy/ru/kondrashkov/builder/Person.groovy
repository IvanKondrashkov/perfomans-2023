package ru.kondrashkov.builder

class Person {
    String firstName
    String lastName
    int age
    Double salary

    void setFirstName(String firstName) {
        this.firstName = firstName
    }

    void setLastName(String lastName) {
        this.lastName = lastName
    }

    void setAge(int age) {
        this.age = age
    }

    void setSalary(Double salary) {
        this.salary = salary
    }
}