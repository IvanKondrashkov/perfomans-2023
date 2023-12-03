package ru.kondrashkov

import groovy.transform.TupleConstructor

@TupleConstructor
class Engine implements OilControl {
    String type

    @Override
    Double level(Integer from, Integer to) {
        return Math.random()
    }
}