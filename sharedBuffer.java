package producerConsumer;
import java.util.LinkedList;
import java.util.Queue;


	public class sharedBuffer {
	    private final Queue<Integer> buffer = new LinkedList<>();
	    private final int MAX_SIZE = 5; // buffer can hold max 5 items

	    // Producer calls this
	    public synchronized void produce(int item) throws InterruptedException {
	        // If buffer is full, Producer WAITS
	        while (buffer.size() == MAX_SIZE) {
	            System.out.println("Buffer FULL! Producer waiting...");
	            wait(); // releases lock and waits
	        }

	        buffer.add(item);
	        System.out.println("Produced: " + item + " | Buffer size: " + buffer.size());

	        notifyAll(); // wake up waiting Consumers
	    }

	    // Consumer calls this
	    public synchronized int consume() throws InterruptedException {
	        // If buffer is empty, Consumer WAITS
	        while (buffer.isEmpty()) {
	            System.out.println("Buffer EMPTY! Consumer waiting...");
	            wait(); // releases lock and waits
	        }

	        int item = buffer.poll();
	        System.out.println("Consumed: " + item + " | Buffer size: " + buffer.size());

	        notifyAll(); // wake up waiting Producers
	        return item;
	    }
	}


