package lessons.lesson11;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class WorkerThread extends Thread {
    private final BlockingQueue<Runnable> queue;
    private final AtomicBoolean isRunning;

    public WorkerThread(BlockingQueue<Runnable> taskQueue, AtomicBoolean isRunning, int id) {
        super("Worker-Thread-" + id);
        this.queue = taskQueue;
        this.isRunning = isRunning;
    }

    public void run() {
        System.out.println("Worker thread started: " + Thread.currentThread().getName());

        while (isRunning.get() || !queue.isEmpty()) {
            try {
                Runnable task = queue.poll(100, TimeUnit.MILLISECONDS);

                if (task != null) {
                    System.out.println(Thread.currentThread().getName() + " is running a task");
                    task.run();
                    System.out.println(Thread.currentThread().getName() + " finished a task");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " shutdown");
            }
        }
        System.out.println("Worker thread stopped: " + Thread.currentThread().getName());
    }
}

class SimpleThreadPool {
    private final  BlockingQueue<Runnable> queue;
    private final WorkerThread[] threads;
    private final AtomicBoolean isRunning;
    private final int poolSize;

    public SimpleThreadPool(int poolSize) {
        if (poolSize <= 0) {
            throw new IllegalArgumentException("poolSize must be greater than 0");
        }

        this.poolSize = poolSize;
        queue = new ArrayBlockingQueue<>(poolSize);
        isRunning = new AtomicBoolean(true);
        threads = new WorkerThread[poolSize];

        for (int i = 0; i < poolSize; i++) {
            threads[i] = new WorkerThread(queue, isRunning, i);
            threads[i].start();
        }
        System.out.println("Pool of threads is created with size " + poolSize);
    }

    public void submit(Runnable task) {
        if (!isRunning.get()) {
            throw  new IllegalStateException("Worker thread is not running");
        }
        try {
            queue.put(task);
            System.out.println(Thread.currentThread().getName() + " submitted a task");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " shutdown");
        }
    }
    public void shutdown() {
        isRunning.set(false);

        for (WorkerThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " shutdown");
            }
        }
        System.out.println("Pool is fully finished");
    }
}

public class ThreadsPoolsController {
    public  static void main(String[] args) {
        SimpleThreadPool pool = new SimpleThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int finalTaskId = i;
            pool.submit(() -> {
                System.out.println(finalTaskId + " is running a task");
            });

            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println(finalTaskId + " shutdown");
            }
        }
        pool.shutdown();
        System.out.println("Program is finished");
    }
}