## Problem: 
Design a fixed-capacity queue. If it’s full, enqueue() should block. If it's empty, dequeue() should block

---

A **Bounded Blocking Queue** is a classic concurrency data structure used in multithreaded systems. Let me break it down for you:

---

### 🧩 What it is
- A **queue** with a **fixed capacity** (bounded).
- Supports two main operations:
    - **enqueue()** → add an element.
    - **dequeue()** → remove an element.
- Both operations can **block**:
    - If the queue is **full**, `enqueue()` waits until space is available.
    - If the queue is **empty**, `dequeue()` waits until an item is available.

---

### ⚙️ Why it matters
- It’s a **producer-consumer synchronization tool**.
- Ensures **safe communication** between threads without busy waiting.
- Prevents data races and ensures **flow control** (producers don’t overwhelm consumers, consumers don’t starve).

---

### 🔑 Key Concepts
- **Bounded capacity**: prevents unbounded memory growth.
- **Blocking behavior**: threads wait instead of failing immediately.
- **Thread safety**: multiple producers and consumers can operate concurrently.
- **Condition variables / semaphores**: typically used to implement blocking.

---

### 💻 Example (Java-style pseudocode)

```java
class BoundedBlockingQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    private int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // block until space is available
        }
        queue.add(item);
        notifyAll(); // wake up waiting consumers
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // block until item is available
        }
        T item = queue.remove();
        notifyAll(); // wake up waiting producers
        return item;
    }
}
```

---

### 🚀 Where it’s used
- **Producer-consumer systems** (e.g., logging frameworks, job schedulers).
- **Thread pools** (workers consume tasks from a bounded queue).
- **Streaming systems** (buffering data between stages).

---

This is essentially a **synchronization primitive** that balances throughput between producers and consumers.

Would you like me to show you a **visual diagram of how producers and consumers interact with a bounded blocking queue** or a **step-by-step walkthrough of enqueue/dequeue blocking behavior**?