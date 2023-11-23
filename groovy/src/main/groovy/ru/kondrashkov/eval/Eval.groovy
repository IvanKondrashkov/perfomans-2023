package ru.kondrashkov.eval

class Eval {

    static byExpression(Integer x, Integer y, Integer z, String expression) {
        return groovy.util.Eval.xyz(x, y, z, expression)
    }
}