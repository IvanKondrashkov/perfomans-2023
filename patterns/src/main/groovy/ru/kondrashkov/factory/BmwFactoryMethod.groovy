package ru.kondrashkov.factory

class BmwFactoryMethod extends CarFactoryMethod {

    @Override
    Car getCar() {
        return new Bmw()
    }
}