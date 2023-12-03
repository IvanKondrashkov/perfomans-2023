package ru.kondrashkov.builder

interface PersonBuilder {
    PersonBuilder setFirstName(String firstName)
    PersonBuilder setLastName(String lastName)
    PersonBuilder setAge(int age)
    PersonBuilder setSalary(Double salary)
    Person build()
}