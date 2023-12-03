package ru.kondrashkov.factory

abstract class CarFactoryMethod {
    abstract Car getCar()

    Car createCar() {
        return getCar()
    }
}