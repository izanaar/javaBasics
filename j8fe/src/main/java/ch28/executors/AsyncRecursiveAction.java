package ch28.executors;

import ch28.executors.actions.MyRecursiveAction;

public class AsyncRecursiveAction {
    public static void main(String[] args) throws InterruptedException {
        MyRecursiveAction action = new MyRecursiveAction(1500, "action 1");
        action.fork();
        Thread.sleep(2000);
    }
}



