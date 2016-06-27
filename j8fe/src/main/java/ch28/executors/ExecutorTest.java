package ch28.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ExecutorTest {
    public static void main(String[] args) {
        Runnable action = ()->{
            System.out.println("Execution has started.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Execution has ended.");
        };



        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(action);
        executor.execute(action);

        System.out.println("After executor started.");
        executor.shutdown();
    }
}
