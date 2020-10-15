package item78.fixedstopthread1;

import java.util.concurrent.TimeUnit;

// Properly synchronized cooperative thread termination
public class StopThread {
    private static boolean stopRequested;

    // the synchronization on these methods is used solely for its communication effects, not for mutual exclusion.
    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i=0;
            while (!stopRequested())
                i++;
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
