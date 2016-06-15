package ch28.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class JoinPool1 implements TaskListener{

    List<MyTaskExecutor> myTasks = new ArrayList<>(5);

    public static void main(String[] args) throws InterruptedException {
        JoinPool1 pool = new JoinPool1();

        pool.myTasks.add(new MyTaskExecutor("Task 1", pool));
        pool.myTasks.add(new MyTaskExecutor("Task 2", pool));
        pool.myTasks.add(new MyTaskExecutor("Task 3", pool));



    }

    @Override
    public void acceptSuccess(String id) {
        System.out.println("Success " + id);
    }
}

class MyTaskExecutor extends RecursiveAction{

    private String id;
    private TaskListener listener;

    public MyTaskExecutor(String id, TaskListener listener) {
        this.id = id;
        this.listener = listener;
    }

    @Override
    protected void compute() {
        System.out.println("Task " + id + " has been started.");

        for(int i = 0; i < 5; i++){
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Task " + id + " has been interrupted.");
            }
            System.out.println("Task " + id + " - " + i + ".");
        }

        System.out.println("Task " + id + " has been completed.");
        listener.acceptSuccess(id);
    }
}

interface TaskListener{
    void acceptSuccess(String id);
}
