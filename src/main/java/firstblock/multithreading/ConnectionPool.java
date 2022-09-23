package firstblock.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Vector;

public class ConnectionPool {
    final Logger LOG_CONNECTION_POOL = LogManager.getLogger(ConnectionPool.class.getName());
    private static ConnectionPool connectionPool;
    private final int noOfThreads;
    private Vector<Connection> connections = new Vector<>();
    private boolean isStopped = false;

    public ConnectionPool(int noOfThreads) {
        this.noOfThreads = noOfThreads;
    }

    public Vector<Connection> getConnections() {
        return connections;
    }

    private void bringConnectionToPool(Connection connection) {
        connections.add(connection);
    }

    public void releaseConnectionFromPool(Connection connection) {
        connections.remove(connection);
    }

    public synchronized Connection getConnection() {
        Connection connection = null;
        if (connections.size() < noOfThreads) {
            connection = new Connection(connections.size() + 1);
            bringConnectionToPool(connection);
        } else {
            LOG_CONNECTION_POOL.info("There are no free slots. Connection will get to queue and the program will try to bring it to ConnectionPool every 2 seconds");
            int maxAttempts = 0;
            while (maxAttempts < 5 && !connection.isAvailable()) {
                waitForConnection();
                //ask again after 2 seconds
                if (connections.size() < noOfThreads) {
                    connection = new Connection(connections.size() + 1);
                    bringConnectionToPool(connection);
                }
                maxAttempts++;
            }
        }
        return connection;
    }

    public synchronized void waitForConnection() {
        try {
            //sleeps for 2 seconds
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




