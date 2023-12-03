package ru.kondrashkov.facade

class LiveRoom {
    RoomFacade roomFacade

    LiveRoom(RoomFacade roomFacade) {
        this.roomFacade = roomFacade
    }

    void pressButton(String channel, String temperature) {
        roomFacade.pressButton(channel, temperature)
    }
}