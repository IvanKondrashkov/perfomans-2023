package ru.kondrashkov.model

import groovy.transform.Immutable

@Immutable
class UserCredentials {
    String login
    String password
}