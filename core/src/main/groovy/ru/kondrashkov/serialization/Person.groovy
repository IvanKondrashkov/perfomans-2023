package ru.kondrashkov.serialization

import groovy.transform.TupleConstructor

@TupleConstructor
class Person implements Serializable {
    int age
    String name
}