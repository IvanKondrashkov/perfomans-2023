package ru.kondrashkov.functional.service

@FunctionalInterface
interface FilmUnaryOperator {
    abstract Double apply(Double rating)
}