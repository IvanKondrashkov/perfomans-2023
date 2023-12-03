package ru.kondrashkov.adapter

class Adapter implements EuroSocket {
    AmericanSocket americanSocket

    Adapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket
    }

    @Override
    int getPower() {
        return americanSocket.getPower()
    }
}