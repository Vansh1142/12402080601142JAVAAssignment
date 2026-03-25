// Problem Statement:
// Producer–Consumer Problem Synchronization and Inter-thread Communication
class SharedBuffer {
    private int data;
    private boolean hasData = false;

    // Producer puts data
    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait(); // wait until consumer consumes
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify(); // notify consumer
    }

    // Consumer takes data
    public synchronized void consume() throws InterruptedException {
        while (!hasData) {
            wait(); // wait until producer produces
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify(); // notify producer
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;
    public Producer(SharedBuffer buffer) { this.buffer = buffer; }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try { buffer.produce(i); } catch (InterruptedException e) {}
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;
    public Consumer(SharedBuffer buffer) { this.buffer = buffer; }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try { buffer.consume(); } catch (InterruptedException e) {}
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();
        new Producer(buffer).start();
        new Consumer(buffer).start();
    }
}
