package ru.kondrashkov.stream.model

import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
class Genre {
    Integer id
    String name
}