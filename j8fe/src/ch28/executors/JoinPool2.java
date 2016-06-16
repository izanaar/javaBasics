package ch28.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class JoinPool2 {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(1);

        MyAction action1 = new MyAction("1"),
                action2 = new MyAction("2"),
                action3 = new MyAction("3"),
                action4 = new MyAction("4");

        List<MyAction> myActions = Arrays.asList(action1, action2, action3, action4);

        myActions.forEach(pool::execute);

        Thread.sleep(1);
        System.out.println("Task 1 cancel attempt: " + action1.cancel(true));
        System.out.println("Task 3 cancel attempt: " + action3.cancel(true));


        Thread.sleep(3000);
        myActions.forEach(System.out::println);
    }
}

class MyAction extends RecursiveAction {

    String name;

    public MyAction(String name) {
        this.name = name;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        System.out.println("Cancelling task " + name);
        return super.cancel(mayInterruptIfRunning);
    }

    @Override
    protected void compute() {
        try {
            System.out.println("Task " + name + " started.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Task " + name + " completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyAction{" +
                "name='" + name + '\'' +
                "isDone='" + super.isDone() + '\'' +
                "isCancelled='" + super.isCancelled() + '\'' +
                "isCompletedNormally='" + super.isCompletedNormally() + '\'' +
                "isCompletedAbnormally='" + super.isCompletedAbnormally() + '\'' +
                '}';
    }
}
