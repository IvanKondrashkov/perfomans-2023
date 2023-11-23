package ru.kondrashkov.model

import groovy.transform.TupleConstructor

@TupleConstructor
class User {
    Integer id
    String name
    UserCredentials credentials
}