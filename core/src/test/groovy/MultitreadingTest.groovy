import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import ru.kondrashkov.multitreading.Batch
import ru.kondrashkov.multitreading.Sender
import ru.kondrashkov.multitreading.Receiver
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Semaphore
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class MultitreadingTest {
    Batch batch
    Sender sender
    Receiver receiver

    @BeforeEach
    void init() {
        batch = new Batch()
        sender = new Sender(batch)
        receiver = new Receiver(batch)
    }

    @AfterEach
    void tearDown() {
        batch = null
        sender = null
        receiver = null
    }

    @Test
    void checkBatchSendAndReceive() {
        new Thread(sender).start()
        new Thread(receiver).start()

        Thread.sleep(1000)

        assert batch.data.size() == 4
        assert receiver.data.size() == 4
    }

    @Test
    void checkState() {
        Thread source = new Thread(sender)
        Thread target = new Thread(receiver)

        assert source.getState() == Thread.State.NEW
        assert target.getState() == Thread.State.NEW

        source.start()
        assert source.getState() == Thread.State.RUNNABLE

        target.start()
        assert target.getState() == Thread.State.RUNNABLE

        Thread.sleep(100)
        assert source.getState() == Thread.State.TIMED_WAITING
        assert target.getState() == Thread.State.TIMED_WAITING

        Thread.sleep(10000)
        assert source.getState() == Thread.State.TERMINATED
        assert target.getState() == Thread.State.TERMINATED
    }

    @Test
    void checkLock() {
        Lock lock = new ReentrantLock()

        new Thread(sender).start()
        new Thread(receiver).start()
        Thread.sleep(1000)

        def sum = receiver.sum(lock)

        assert sum == 10
    }

    @Test
    void checkSemaphore() {
        Semaphore semaphore = new Semaphore(1)

        ExecutorService executor = Executors.newSingleThreadExecutor()
        executor.execute {
            semaphore.acquire()
        }
        executor.shutdown()
        Thread.sleep(100)

        assert semaphore.availablePermits() == 0
        assert !semaphore.tryAcquire()
    }
}