package ru.kondrashkov.stream.model

import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
class Like {
    Integer id
    Boolean isLike
}