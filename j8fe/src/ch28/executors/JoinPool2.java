package ch28.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class JoinPool2 {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(1);

        List<MyAction> actionList =
                Arrays.asList(new MyAction("1"), new MyAction("2"), new MyAction("3"), new MyAction("4"));

        actionList.forEach(pool::execute);

        //Thread.sleep(20);
        System.out.println("Action 1 cancel attempt result: " + actionList.get(0).cancel(true));
        System.out.println("Action 3 cancel attempt result: " + actionList.get(2).cancel(true));

        Thread.sleep(4000);

        actionList.forEach(System.out::println);
    }
}

class MyAction extends RecursiveAction {

    private AtomicBoolean operationStarted;
    private String name;

    public MyAction(String name) {
        this.name = name;
        operationStarted = new AtomicBoolean(false);
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return !operationStarted.get() && super.cancel(mayInterruptIfRunning);
    }

    @Override
    protected void compute() {
        System.out.println("Action " + name + " has started.");
        operationStarted.set(true);
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Action " + name + " has completed.");
    }

    @Override
    public String toString() {
        return "Action " + name + "{" +
                "cancelled:'" + super.isCancelled() +
                "' done:'" + super.isDone() +
                "' completedNormally:'" + super.isCompletedNormally() +
                "' completedAbnormally:'" + super.isCompletedAbnormally() + "}";
    }
}

