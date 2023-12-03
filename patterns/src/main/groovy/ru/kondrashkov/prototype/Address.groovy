package ru.kondrashkov.prototype

class Address {
    String street

    Address(String street) {
        this.street = street
    }

    Address(Address address) {
        this.street = address.street
    }
}