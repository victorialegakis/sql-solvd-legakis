package hometask.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientsRunner {
    public static void main(String[] args) {
        final Logger LOG_THREAD_POOL = LogManager.getLogger(ClientsRunner.class.getName());
        ConnectionPool threadPool = new ConnectionPool(5, 7);

        for (int i = 1; i < 8; i++) {

            int taskNo = i;
            threadPool.execute(() -> {
                String message = Thread.currentThread().getName() + ": Task " + taskNo;
                LOG_THREAD_POOL.info(message);
            });

        }
        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
        LOG_THREAD_POOL.info("All tasks have finished and the thread pool has been stopped.");


    }
}
