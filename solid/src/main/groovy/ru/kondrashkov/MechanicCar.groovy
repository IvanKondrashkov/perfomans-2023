package ru.kondrashkov

class MechanicCar extends Car implements Navigation {
    Engine engine

    MechanicCar(String model, Integer number, Engine engine) {
        super(model, number)
        this.engine = engine
    }

    @Override
    String drive(Integer km) {
        return "Drive mechanic car go to $km"
    }

    @Override
    Integer navigate(Double x, Double y) {
        return Double.sum(x, y).toInteger()
    }
}