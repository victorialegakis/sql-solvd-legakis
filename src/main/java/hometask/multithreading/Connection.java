package hometask.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {

    private int number;
    private boolean isAvailable;

    final Logger LOG_CONNECTION = LogManager.getLogger(Connection.class.getName());

    public Connection(int number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getNumber() {
        return number;
    }

    public void connect(int taskNo) {
        LOG_CONNECTION.info("Connecting from connection number " + number + " for task " + taskNo + "...");
        isAvailable = false;
    }

    public void disconnect(int taskNo) {
        LOG_CONNECTION.info("Disconnecting from connection number " + number + " for task " + taskNo + "...");
        isAvailable = true;
    }

}