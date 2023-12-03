package ru.kondrashkov.functional.service

import ru.kondrashkov.stream.model.Film

@FunctionalInterface
interface FilmPredicate {
    abstract boolean test(Film film)
}