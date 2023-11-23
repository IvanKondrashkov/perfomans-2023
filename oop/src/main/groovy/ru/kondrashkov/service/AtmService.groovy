package ru.kondrashkov.service

import ru.kondrashkov.model.Money

interface AtmService {
    Money plus(Money other)
    Money minus(Money other)
}