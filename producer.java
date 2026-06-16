package producerConsumer;

public class producer implements Runnable {
    private final sharedBuffer buffer;
    private final String name;

    public producer(sharedBuffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        int item = 1;
        while (true) {
            try {
                System.out.println("[" + name + "] Producing item: " + item);
                buffer.produce(item++);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
