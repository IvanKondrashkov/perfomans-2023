package ru.kondrashkov.bridge

class Toyota implements Model {

    @Override
    void drive(String run) {
        println("${run} toyota")
    }
}