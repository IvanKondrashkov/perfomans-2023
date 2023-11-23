package ru.kondrashkov.exception

class UserNotFoundException extends RuntimeException {
    UserNotFoundException() {
        super()
    }

    UserNotFoundException(String message) {
        super(message)
    }
}