package ru.kondrashkov.functional.service

import ru.kondrashkov.stream.model.Like
import ru.kondrashkov.stream.model.Film

@FunctionalInterface
interface FilmFunction {
    abstract Set<Like> apply(Film film)
}