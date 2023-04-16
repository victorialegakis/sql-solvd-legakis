package firstblock.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ClientsRunner {

    private static ConnectionPool connectionPool = new ConnectionPool(5);

    public static void main(String[] args) throws InterruptedException {
        final Logger LOG_THREAD_POOL = LogManager.getLogger(ClientsRunner.class.getName());
        final int MAX_THREAD = 5;
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(MAX_THREAD);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(MAX_THREAD, MAX_THREAD, 5, TimeUnit.SECONDS, queue);
        for (int i = 1; i < 8; i++) {
            int finalI = i;
            Runnable connection = () -> {
                try {
                    Connection connection1 = connectionPool.getConnection();
                    connection1.connect(finalI);
                    connectionPool.waitForConnection();
                    connection1.disconnect(finalI);
                    connectionPool.releaseConnectionFromPool(connection1);
                } catch (RuntimeException e) {
                    LOG_THREAD_POOL.info(e.getMessage());
                }
            };
            threadPoolExecutor.execute(connection);
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()) {
            threadPoolExecutor.awaitTermination(1, TimeUnit.SECONDS);
        }
        LOG_THREAD_POOL.info("Finished all tasks and connection Pool size is " + connectionPool.getConnections().size());
    }

}
