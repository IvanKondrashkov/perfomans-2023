package ru.kondrashkov

import groovy.transform.TupleConstructor

@TupleConstructor
abstract class Car {
    String model
    Integer number

    abstract String drive(Integer km)
}