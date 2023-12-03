package ru.kondrashkov.decorator

class CheesePizza implements Pizza {
    Pizza pizza

    CheesePizza(Pizza pizza) {
        this.pizza = pizza
    }

    @Override
    String makePizza() {
        return "${pizza.makePizza()} add cheese"
    }
}