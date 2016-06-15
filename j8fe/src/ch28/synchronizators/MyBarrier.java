package ch28.synchronizators;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyBarrier {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(3);
        VarInitializer[] initializers = new VarInitializer[3];
        for(int i = 0; i<2;i++)
            initializers[i] = new VarInitializer(cb, "initializer " + i);
        System.out.println("var 3 will be initialized in a sec");
        Thread.sleep(1000);
        initializers[2] = new VarInitializer(cb, "initializer 3");
    }
}

class VarInitializer implements Runnable{
    long time;
    CyclicBarrier cb;
    String name;

    public VarInitializer(CyclicBarrier cb, String name) {
        this.cb = cb;
        this.name = name;
        new Thread(this, name).start();
    }


    @Override
    public void run() {
        try {
            time = new Date().getTime();
            System.out.println(name + " is waiting for all variables initialized");
            cb.await();
            System.out.println(name + "val: " + time);
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        }
    }
}
