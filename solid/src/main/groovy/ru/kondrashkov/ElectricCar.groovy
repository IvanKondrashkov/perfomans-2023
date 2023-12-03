package ru.kondrashkov

class ElectricCar extends Car implements Navigation {
    Engine engine

    ElectricCar(String model, Integer number, Engine engine) {
        super(model, number)
        this.engine = engine
    }

    @Override
    String drive(Integer km) {
        return "Drive electric car go to $km"
    }

    @Override
    Integer navigate(Double x, Double y) {
        return new Random().nextInt()
    }
}