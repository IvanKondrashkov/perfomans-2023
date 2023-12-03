package ru.kondrashkov.factory

class Bmw implements Car {

    @Override
    void drive(String run) {
        println("${run} bmw")
    }
}