package ru.kondrashkov.bridge

abstract class Vehicle {
    Model model

    Vehicle(Model model) {
        this.model = model
    }

    abstract void drive()
}