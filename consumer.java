package producerConsumer;

public class consumer implements Runnable {
    private final sharedBuffer buffer;
    private final String name;

    public consumer(sharedBuffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int item = buffer.consume();
                System.out.println("[" + name + "] Processing item: " + item);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}