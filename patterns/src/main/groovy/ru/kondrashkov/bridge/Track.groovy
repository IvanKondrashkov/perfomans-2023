package ru.kondrashkov.bridge

class Track extends Vehicle {

    Track(Model model) {
        super(model)
    }

    @Override
    void drive() {
        model.drive('drive track')
    }
}