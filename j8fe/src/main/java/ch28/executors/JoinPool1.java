package ch28.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class JoinPool1{

    private static List<MyTask> myTasks = new ArrayList<>(5);
    private static ForkJoinPool pool = ForkJoinPool.commonPool();

    public static void main(String[] args) throws InterruptedException {
        myTasks.add(new MyTask("Task 1",  5));
        myTasks.add(new MyTask("Task 2",  2));
        myTasks.add(new MyTask("Task 3",  4));

        myTasks.forEach(pool::execute);
        watch();
    }

    private static void watch() {
        for(int i = 0; i < 7; i++){
            System.out.println("Task status:");
            myTasks.forEach(JoinPool1::showStatus);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void showStatus(MyTask task){
        System.out.println("Task " + task.id + " is done:" + task.isDone());
    }

}

class MyTask extends RecursiveAction {

    String id;
    private int limit;

    MyTask(String id, int limit) {
        this.id = id;
        this.limit = limit;
    }


    @Override
    protected void compute() {
        System.out.println("Task " + id + " has been started.");

        for (int i = 0; i < limit; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Task " + id + " has been interrupted.");
            }
            System.out.println("Task " + id + " - " + i + ".");
        }

        System.out.println("Task " + id + " has been completed.");
    }
}