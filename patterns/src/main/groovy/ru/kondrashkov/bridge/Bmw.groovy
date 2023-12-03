package ru.kondrashkov.bridge

class Bmw implements Model {

    @Override
    void drive(String run) {
        println("${run} bmw")
    }
}