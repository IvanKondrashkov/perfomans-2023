package ru.kondrashkov.factory

class BmwBike implements Bike {

    @Override
    void drive(String run) {
        println("${run} bmw bike")
    }
}