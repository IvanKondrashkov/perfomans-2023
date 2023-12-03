package ru.kondrashkov.builder

class PersonBuilderImpl implements PersonBuilder {
    Person person

    PersonBuilderImpl() {
        this.person = new Person()
    }

    @Override
    PersonBuilder setFirstName(String firstName) {
        person.firstName = firstName
        return this
    }

    @Override
    PersonBuilder setLastName(String lastName) {
        person.lastName = lastName
        return this
    }

    @Override
    PersonBuilder setAge(int age) {
        person.age = age
        return this
    }

    @Override
    PersonBuilder setSalary(Double salary) {
        person.salary = salary
        return this
    }

    @Override
    Person build() {
        return person
    }
}
