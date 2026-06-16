package producerConsumer;  



public class main {
    public static void main(String[] args) {
        sharedBuffer buffer = new sharedBuffer();

        Thread producer1 = new Thread(new producer(buffer, "Producer-1"));
        Thread producer2 = new Thread(new producer(buffer, "Producer-2"));
        Thread consumer1 = new Thread(new consumer(buffer, "Consumer-1"));
        Thread consumer2 = new Thread(new consumer(buffer, "Consumer-2"));

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producer1.interrupt();
        producer2.interrupt();
        consumer1.interrupt();
        consumer2.interrupt();

        System.out.println("Program ended.");
    }
}