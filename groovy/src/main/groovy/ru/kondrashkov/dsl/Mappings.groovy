package ru.kondrashkov.dsl

import groovy.transform.ToString

@ToString(includeFields = true)
class Mappings {
    String url
    Boolean active
}