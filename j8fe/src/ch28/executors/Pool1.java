package ch28.executors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool1 {
    public static void main(String[] args) {
        CountDownLatch cd1 = new CountDownLatch(5),
                cd2 = new CountDownLatch(5),
                cd3 = new CountDownLatch(5),
                cd4 = new CountDownLatch(5),
                cd5 = new CountDownLatch(5);

        ExecutorService exec =
                Executors.newFixedThreadPool(2);
                //Executors.newSingleThreadExecutor();
                //Executors.newCachedThreadPool();

        exec.execute(new CountDowner(cd1, "A"));
        exec.execute(new CountDowner(cd2, "B"));
        exec.execute(new CountDowner(cd3, "C"));
        exec.execute(new CountDowner(cd4, "D"));
        exec.execute(new CountDowner(cd5, "E"));



        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();

            exec.shutdownNow().forEach(System.out::println);

            Runnable shutDownable = new CountDowner("Q");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        exec.shutdown();
    }
}

class CountDowner implements Runnable{

    private CountDownLatch cd;
    private String name;

    public CountDowner(String name) {
        this.name = name;
    }

    public CountDowner(CountDownLatch cd, String name) {
        this.cd = cd;
        this.name = name;
        new Thread(this);
    }
    @Override
    public void run() {

        for(int i = 0; i < 5; i++){
            System.out.println("Thread " + name + " count: " + i);
            if(cd != null){
                cd.countDown();
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return "CountDowner{" +
                "name='" + name + '\'' +
                '}';
    }
}
