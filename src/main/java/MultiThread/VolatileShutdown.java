package MultiThread;

/**
 * Created by hupo.wh on 2016/7/8.
 */
public class VolatileShutdown {

    volatile boolean shutdownRequested;

    public void shutdown() {

        shutdownRequested = true;
    }

    public void doWork() {

        while (!shutdownRequested) {

            //do stuff
        }
    }

}
