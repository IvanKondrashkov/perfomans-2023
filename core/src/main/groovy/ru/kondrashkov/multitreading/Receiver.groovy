package ru.kondrashkov.multitreading

import java.util.concurrent.locks.Lock
import java.util.concurrent.atomic.AtomicReference

class Receiver implements Runnable {
    final Batch batch
    final List<AtomicReference<String>> data

    Receiver(Batch batch) {
        this.batch = batch
        this.data = []
    }

    @Override
    void run() {
        def index = 0

        while (index != 4) {
            def element = batch.receiveBatch().get(index)
            if (element.compareAndSet(element.get(), batch.data.get(index).get())) {
                data << element
            }

            Thread.sleep(300)
            index++
        }
    }

    int sum(Lock lock) {
        lock.lock()
        try {
            return data.sum {it.get().toInteger()}
        } finally {
            lock.unlock()
        }
    }
}