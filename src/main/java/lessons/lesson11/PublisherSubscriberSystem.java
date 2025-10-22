package lessons.lesson11;

import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Publisher implements Runnable {
    private final BlockingQueue<String> queue;
    private final Scanner scanner;
    private volatile boolean running = true;

    public Publisher(BlockingQueue<String> queue) {
        this.queue = queue;
        this.scanner = new Scanner(System.in);
    }
    @Override
    public void run() {
        System.out.println("Publisher is running");
        while (running) {
            String input = scanner.nextLine();
            try {
                if (input.equalsIgnoreCase("exit")) {
                    queue.add("exit");
                    running = false;
                    System.out.println("Exit is called");
                } else {
                    queue.add(input);
                    System.out.println("Message added to queue: " + input);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Publisher is interrupted");
                break;
            }
        }
        scanner.close();
    }

    public void stop() {
        running = false;
    }

}

class Subscriber implements Runnable {

    private final BlockingQueue<String> queue;
    private volatile boolean running = true;

    public Subscriber(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Subscriber is running");
        while (running) {
            try {
                String message = queue.take();

                if (message.equalsIgnoreCase("exit")) {
                    running = false;
                    System.out.println("Exit is called");
                } else {
                    System.out.println("Received message: " + message);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Subscriber is interrupted");
                break;
            }
        }
    }
    public void stop() {
        running = false;
    }
}


public class PublisherSubscriberSystem {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Publisher publisher = new Publisher(queue);
        Subscriber subscriber = new Subscriber(queue);

        Thread publisherThread = new Thread(publisher, "Publisher-Thread");
        Thread subscriberThread = new Thread(subscriber, "Subscriber-Thread");

        publisherThread.start();
        subscriberThread.start();

        try {
            publisherThread.join();
            subscriberThread.join();

            System.out.println("Program is finished successfully");
        }  catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Program is interrupted");
        }

    }
}
