package ru.kondrashkov.functional.service

@FunctionalInterface
interface FilmBinaryOperator {
    abstract GString apply(GString name, GString genre)
}