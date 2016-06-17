package ch28.executors.actions;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {

    private int delay;
    private String name;

    public MyRecursiveAction(String name) {
        this.name = name;
    }

    public MyRecursiveAction(int delay, String name) {
        this.delay = delay;
        this.name = name;
    }

    @Override
    protected void compute() {
        System.out.println("MyAction " + name + " has started.");
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MyAction " + name + " has ended.");
    }

}
