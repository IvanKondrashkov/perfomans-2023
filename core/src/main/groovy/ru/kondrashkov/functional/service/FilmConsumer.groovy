package ru.kondrashkov.functional.service

import ru.kondrashkov.stream.model.Film

@FunctionalInterface
interface FilmConsumer {
    abstract void accept(Film film)
}