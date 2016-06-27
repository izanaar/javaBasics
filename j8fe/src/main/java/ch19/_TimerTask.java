package ch19;

import java.util.Timer;
import java.util.TimerTask;

public class _TimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Timer task is performing");
    }
}

class TimerTest{
    public static void main(String[] args) throws InterruptedException {
        _TimerTask myTask = new _TimerTask();
        Timer myTimer = new Timer();
        myTimer.schedule(myTask,1000,500);

        System.out.println("Main thread will sleep now");
        Thread.sleep(5000);
        myTimer.cancel();
        System.out.println("Main thread completed");
    }
}
