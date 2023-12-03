package ru.kondrashkov.factory

class BmwAbstractFactory implements AbstractFactory {

    @Override
    Car getCar() {
        return new Bmw()
    }

    @Override
    Bike getBike() {
        return new BmwBike()
    }
}