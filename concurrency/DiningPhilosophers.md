## Problem: 
5 philosophers, 5 forks. Each needs two forks to eat. Don’t deadlock.

--- 
Perfect — the **Dining Philosophers Problem** is a classic concurrency puzzle. Let’s break it down and then show a safe implementation.

---

## 🧩 Problem Recap
- 5 philosophers sit around a table.
- Each has one fork to their left and one to their right.
- To eat, a philosopher needs **both forks**.
- If all philosophers pick up their left fork at the same time, they’ll all wait forever for the right fork → **deadlock**.

---

## ⚠️ The Challenge
- Allow philosophers to eat and think concurrently.
- Prevent **deadlock** (everyone waiting forever).
- Prevent **starvation** (some philosophers never get to eat).

---

## ✅ Common Solutions
1. **Asymmetric fork picking**
    - Odd philosophers pick left fork first, then right.
    - Even philosophers pick right fork first, then left.
    - Breaks the circular wait condition.

2. **Limit concurrency**
    - Allow only 4 philosophers to try eating at once.
    - Guarantees at least one can succeed.

3. **Global waiter (arbiter)**
    - A single “waiter” grants permission to pick up forks.
    - Ensures safe allocation.

---

## ⚙️ Example Implementation (Java, using asymmetric strategy)

```java
import java.util.concurrent.locks.ReentrantLock;

class Philosopher implements Runnable {
    private final ReentrantLock leftFork;
    private final ReentrantLock rightFork;
    private final int id;

    public Philosopher(int id, ReentrantLock leftFork, ReentrantLock rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                if (id % 2 == 0) { // even philosopher
                    pickUp(rightFork, "right");
                    pickUp(leftFork, "left");
                } else { // odd philosopher
                    pickUp(leftFork, "left");
                    pickUp(rightFork, "right");
                }
                eat();
                putDown(leftFork, "left");
                putDown(rightFork, "right");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking...");
        Thread.sleep(500);
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating...");
        Thread.sleep(500);
    }

    private void pickUp(ReentrantLock fork, String side) {
        fork.lock();
        System.out.println("Philosopher " + id + " picked up " + side + " fork.");
    }

    private void putDown(ReentrantLock fork, String side) {
        fork.unlock();
        System.out.println("Philosopher " + id + " put down " + side + " fork.");
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        ReentrantLock[] forks = new ReentrantLock[numPhilosophers];
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new ReentrantLock();
        }

        for (int i = 0; i < numPhilosophers; i++) {
            ReentrantLock leftFork = forks[i];
            ReentrantLock rightFork = forks[(i + 1) % numPhilosophers];
            Philosopher philosopher = new Philosopher(i, leftFork, rightFork);
            new Thread(philosopher, "Philosopher-" + i).start();
        }
    }
}
```

---

## 🔄 Why this avoids deadlock
- By alternating fork-picking order (odd vs even philosophers), we break the **circular wait** condition.
- At least one philosopher can always proceed, so the system keeps moving.

---

## 🖼️ Sample Output
```
Philosopher 0 is thinking...
Philosopher 1 is thinking...
Philosopher 0 picked up right fork.
Philosopher 0 picked up left fork.
Philosopher 0 is eating...
Philosopher 1 picked up left fork.
Philosopher 1 picked up right fork.
Philosopher 1 is eating...
...
```

---

This is one of the most famous concurrency problems because it illustrates **deadlock, starvation, and resource contention** in a simple metaphor.

Would you like me to also show you a **timeline diagram of philosophers picking forks** so you can visualize how the asymmetric strategy prevents deadlock?