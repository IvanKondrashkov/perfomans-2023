package ru.kondrashkov.decorator

class BasePizza implements Pizza {

    @Override
    String makePizza() {
        return "create pizza"
    }
}