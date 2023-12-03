package ru.kondrashkov

class CustomCar extends Car {
    Engine engine
    String color

    CustomCar(String model, Integer number, Engine engine, String color) {
        super(model, number)
        this.engine = engine
        this.color = color
    }

    @Override
    String drive(Integer km) {
        if (!km) {
            throw new IllegalAccessException()
        }
        return "Drive custom car go to $km"
    }
}