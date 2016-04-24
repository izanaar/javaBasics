package ch28;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Phaser;

public class MyPhaser {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int currPhase;

        System.out.println("Starting preparation");
        initThreads(phaser);

        phaser.arriveAndAwaitAdvance();
        System.out.println("Stage 1 complete");


        phaser.arriveAndAwaitAdvance();
        System.out.println("Stage 2 complete");


        phaser.arriveAndAwaitAdvance();
        System.out.println("Stage 3 complete");

        phaser.arriveAndDeregister();

        if(phaser.isTerminated())
            System.out.println("Vehicle preparation completed.");
    }

    private static void initThreads(Phaser ph){
        Random r = new Random(new Date().getTime());
        new Mythread(ph,"refuller",r);
        new Mythread(ph,"mechanic",r);
        new Mythread(ph,"engineer",r);
    }
}

class Mythread implements Runnable{

    Phaser phaser;
    String name;
    Random r;

    public Mythread(Phaser phaser, String name, Random r) {
        this.phaser = phaser;
        this.name = name;
        this.r = r;
        phaser.register();
        System.out.println(name + " registered. starting preparation operations...");
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name + "\'s phase 1 has started.");
        try {
            doSomething();
            System.out.println(name + "\'s phase 1 was completed.");
            phaser.arriveAndAwaitAdvance();
            wait10MS();

            System.out.println(name + "\'s phase 2 has started.");
            doSomething();
            System.out.println(name + "\'s phase 2 was completed.");
            phaser.arriveAndAwaitAdvance();
            wait10MS();

            System.out.println(name + "\'s phase 3 has started.");
            doSomething();
            System.out.println(name + "\'s phase 3 was completed.");
            phaser.arriveAndDeregister();
            wait10MS();
            System.out.println(name + "\'s work completed");
        } catch (InterruptedException e) {
            System.out.println(name + " phase interrupted. Reason:\n" + e);
        }

    }

    private void doSomething() throws InterruptedException {
        Thread.sleep(r.nextInt((4000 - 1000) + 1) + 1000);
    }

    private void wait10MS() throws InterruptedException{
        Thread.sleep(10);
    }
}
