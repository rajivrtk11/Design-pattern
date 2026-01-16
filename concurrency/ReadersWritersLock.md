## Problem:
Multiple threads can read simultaneously, but writers need exclusive access.

---

## 🧩 Problem Recap
- **Readers**: Multiple threads can read the shared resource at the same time (safe because reading doesn’t modify data).
- **Writers**: Only one thread can write, and it must have **exclusive access** (no readers or other writers allowed).
- Goal: Maximize concurrency by allowing multiple readers, but ensure writers don’t conflict.

---

## ⚙️ Implementation (Java-style)

Here’s a simple implementation using `ReentrantLock` and `Condition`:

```java
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class ReadersWritersLock {
    private int readers = 0;          // number of active readers
    private boolean writerActive = false; // is a writer active?
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition canRead = lock.newCondition();
    private final Condition canWrite = lock.newCondition();

    // Acquire read lock
    public void lockRead() throws InterruptedException {
        lock.lock();
        try {
            while (writerActive) {
                canRead.await(); // wait until no writer
            }
            readers++;
        } finally {
            lock.unlock();
        }
    }

    // Release read lock
    public void unlockRead() {
        lock.lock();
        try {
            readers--;
            if (readers == 0) {
                canWrite.signal(); // wake up waiting writers
            }
        } finally {
            lock.unlock();
        }
    }

    // Acquire write lock
    public void lockWrite() throws InterruptedException {
        lock.lock();
        try {
            while (writerActive || readers > 0) {
                canWrite.await(); // wait until no readers/writers
            }
            writerActive = true;
        } finally {
            lock.unlock();
        }
    }

    // Release write lock
    public void unlockWrite() {
        lock.lock();
        try {
            writerActive = false;
            canRead.signalAll(); // wake up readers
            canWrite.signal();   // wake up next writer
        } finally {
            lock.unlock();
        }
    }
}
```

---

## 🖥️ Example Usage in `main`

```java
public class Main {
    public static void main(String[] args) {
        ReadersWritersLock rwLock = new ReadersWritersLock();
        StringBuilder sharedData = new StringBuilder("Initial");

        // Reader thread
        Runnable readerTask = () -> {
            try {
                rwLock.lockRead();
                System.out.println(Thread.currentThread().getName() + " reading: " + sharedData);
                Thread.sleep(500); // simulate reading
                rwLock.unlockRead();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Writer thread
        Runnable writerTask = () -> {
            try {
                rwLock.lockWrite();
                sharedData.append(" + updated by " + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + " writing...");
                Thread.sleep(1000); // simulate writing
                rwLock.unlockWrite();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Start multiple readers and writers
        for (int i = 0; i < 3; i++) {
            new Thread(readerTask, "Reader-" + i).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(writerTask, "Writer-" + i).start();
        }
    }
}
```

---

## 🔄 What Happens
- Multiple **readers** can run simultaneously → they don’t block each other.
- A **writer** waits until all readers finish, then locks exclusively.
- While a writer is active, **new readers must wait**.
- Ensures **data consistency** while maximizing concurrency.

---

## 🖼️ Sample Output
```
Reader-0 reading: Initial
Reader-1 reading: Initial
Reader-2 reading: Initial
Writer-0 writing...
Writer-1 writing...
Reader-0 reading: Initial + updated by Writer-0 + updated by Writer-1
...
```

---

This pattern is widely used in **databases, caches, and file systems** where reads are frequent but writes must be carefully controlled.

Would you like me to also show you a **timeline diagram of readers and writers acquiring/releasing locks** so you can visualize how they coordinate?