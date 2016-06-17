package ch28.executors;

import ch28.executors.actions.MyRecursiveAction;

import java.util.concurrent.ForkJoinPool;

public class SyncRecursiveAction {
    public static void main(String[] args) {
        MyRecursiveAction action = new MyRecursiveAction(1500, "action 1");
        ForkJoinPool.commonPool().invoke(action);
    }
}
