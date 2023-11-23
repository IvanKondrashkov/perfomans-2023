package ru.kondrashkov.service

import ru.kondrashkov.model.User
import ru.kondrashkov.model.UserCredentials
import ru.kondrashkov.exception.UserNotFoundException

class LoginService {

    UserCredentials createLogin(User user, String login, String password) {
        if (!user) {
            throw new UserNotFoundException('User not found!')
        }
        return new UserCredentials(login, password)
    }
}