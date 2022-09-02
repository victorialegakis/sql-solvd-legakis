package hometask.multithreading;

import java.util.concurrent.BlockingQueue;

public class Connection implements Runnable {

    private Thread thread = null;
    private BlockingQueue taskQueue = null;
    private boolean isStopped = false;

    public Connection(BlockingQueue queue) {
        taskQueue = queue;
    }

    public void run() {
        this.thread = Thread.currentThread();
        while (!isStopped()) {
            try {
                Runnable connection = (Runnable) taskQueue.take();
                connection.run();
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void disconnect() {
        isStopped = true;
        //break pool thread out of dequeue call.
        this.thread.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}