package concurrency;

public class ThreadTest {
    static int count = 0;
    static Object object = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (object) {
                while (count < 10) {
                    if(count%2 == 0) {
                        System.out.println("counter " + count++);
                        object.notifyAll();
                    }
                    else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (object) {
                while (count < 10) {
                    if(count%2 != 0) {
                        System.out.println("counter " + count++);
                        object.notifyAll();
                    }
                    else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        });

        thread1.start();
        thread2.start();

//        System.out.println("Hello world");
    }
}
