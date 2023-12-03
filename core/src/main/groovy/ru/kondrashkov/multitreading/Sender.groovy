package ru.kondrashkov.multitreading

import java.util.concurrent.atomic.AtomicReference

class Sender implements Runnable {
    final Batch batch

    Sender(Batch batch) {
        this.batch = batch
    }

    @Override
    void run() {
        def data = [
                new AtomicReference<String>('1'),
                new AtomicReference<String>('2'),
                new AtomicReference<String>('3'),
                new AtomicReference<String>('4')
        ]

        data.each {
            batch.sendBatch(it)
            Thread.sleep(300)
        }
    }
}