package ru.kondrashkov.functional.service

import ru.kondrashkov.stream.model.Film
import ru.kondrashkov.stream.model.Like

class FilmService {

    void setRating(List<Film> films, FilmConsumer consumer) {
        films.each {
            consumer.accept(it)
        }
    }

    List<Film> filter(List<Film> films, FilmPredicate predicate) {
        def filtered = []
        films.each {
            if (predicate.test(it)) {
                filtered << it
            }
        }
        return  filtered
    }

    Set<Like> getLikes(List<Film> films, FilmFunction function) {
        def filtered = [] as Set
        films.each {
            filtered << function.apply(it)
        }
        return  filtered
    }

    List<Double> getFilmsRandomRating(List<Film> films, FilmSupplier supplier) {
        def filtered = []
        films.each {
            filtered << supplier.get()
        }
        return  filtered
    }

    List<Double> getFilmsRatingX2(List<Film> films, FilmUnaryOperator unaryOperator) {
        def filtered = []
        films.each {
            filtered << unaryOperator.apply(it.rating)
        }
        return  filtered
    }

    List<String> getFilmsShortDescription(List<Film> films, FilmBinaryOperator binaryOperator) {
        def filtered = []
        films.each {
            filtered << binaryOperator.apply("$it.name", "$it.genre.name")
        }
        return  filtered
    }
}