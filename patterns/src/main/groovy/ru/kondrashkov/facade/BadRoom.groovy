package ru.kondrashkov.facade

class BadRoom {
    RoomFacade roomFacade

    BadRoom(RoomFacade roomFacade) {
        this.roomFacade = roomFacade
    }

    void pressButton(String channel, String temperature) {
        roomFacade.pressButton(channel, temperature)
    }
}