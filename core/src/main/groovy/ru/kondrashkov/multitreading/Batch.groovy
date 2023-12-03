package ru.kondrashkov.multitreading

import java.util.concurrent.atomic.AtomicReference

class Batch {
    final List<AtomicReference<String>> data
    boolean isSend = true

    Batch() {
        this.data = []
    }

    synchronized List<AtomicReference<String>> receiveBatch() {
        while (isSend) {
            try {
                wait()
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt()
            }
        }

        isSend = true
        notifyAll()
        return data
    }

    synchronized void sendBatch(AtomicReference<String> message) {
        while (!isSend) {
            try {
                wait()
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt()
            }
        }

        isSend = false
        data.add(message)
        notifyAll()
    }
}