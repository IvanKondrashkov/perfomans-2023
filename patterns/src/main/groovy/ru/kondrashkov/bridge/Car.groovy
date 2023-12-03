package ru.kondrashkov.bridge

class Car extends Vehicle {

    Car(Model model) {
        super(model)
    }

    @Override
    void drive() {
        model.drive('drive car')
    }
}