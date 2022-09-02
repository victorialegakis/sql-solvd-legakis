package hometask.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private BlockingQueue taskQueue = null;
    private List<Connection> connections = new ArrayList<>();
    private boolean isStopped = false;

    public ConnectionPool(int noOfThreads, int maxNoOfTasks) {
        taskQueue = new ArrayBlockingQueue(maxNoOfTasks);

        for (int i = 0; i < noOfThreads; i++) {
            Connection poolThreadConnection =
                    new Connection(taskQueue);

            connections.add(poolThreadConnection);
        }
        for (Connection connection : connections) {
            new Thread(connection).start();
        }
    }

    public synchronized void execute(Runnable task) throws IllegalStateException {
        if (this.isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }

        this.taskQueue.offer(task);
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (Connection connection : connections) {
            connection.disconnect();
        }
    }

    public synchronized void waitUntilAllTasksFinished() {
        while (this.taskQueue.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}