# Producer-Consumer-Java
# Producer-Consumer System in Java

## About
A multithreaded Producer-Consumer implementation in Java demonstrating 
core concurrency and synchronization concepts.

## Concepts Demonstrated
- Multi-threading (2 Producers + 2 Consumers running simultaneously)
- Thread Synchronization (synchronized keyword)
- Inter-thread communication (wait() and notifyAll())
- Bounded buffer management (max size 5)
- Deadlock prevention
- Race condition handling

## How It Works
- 2 Producer threads produce items every 0.5 seconds
- 2 Consumer threads consume items every 1 second
- If buffer is FULL → Producers wait automatically
- If buffer is EMPTY → Consumers wait automatically
- All 4 threads run concurrently for 10 seconds then stop cleanly

## How to Run
1. Clone this repository
2. Open Eclipse IDE
3. Import as Java Project
4. Run main.java as Java Application

## Technologies Used
- Java
- Core Java Multithreading
- synchronized, wait(), notifyAll()
- Java Collections (LinkedList, Queue)
