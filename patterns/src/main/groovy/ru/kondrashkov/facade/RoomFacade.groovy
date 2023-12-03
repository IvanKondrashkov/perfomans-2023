package ru.kondrashkov.facade

class RoomFacade {
    Tv tv
    Light light
    Conditioner conditioner

    RoomFacade() {
        this.tv = new Tv()
        this.light = new Light()
        this.conditioner = new Conditioner()
    }

    void pressButton(String channel, String temperature) {
        tv.playChannel(channel)
        light.turnLight()
        conditioner.setTemperature(temperature)
    }
}