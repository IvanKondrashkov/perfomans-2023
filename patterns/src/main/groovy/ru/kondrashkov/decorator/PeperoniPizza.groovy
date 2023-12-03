package ru.kondrashkov.decorator

class PeperoniPizza implements Pizza {
    Pizza pizza

    PeperoniPizza(Pizza pizza) {
        this.pizza = pizza
    }

    @Override
    String makePizza() {
        return "${pizza.makePizza()} add peperoni"
    }
}