package ru.kondrashkov.stream.model

import groovy.transform.ToString
import groovy.transform.TupleConstructor
import ru.kondrashkov.annotation.Id

@ToString
@TupleConstructor
class Film {
    @Id
    Integer id
    String name
    Double rating
    Genre genre
    Set<Like> likes
}