package ch28.synchronizers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MyCountDown {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        ArrayList<Vehicle> vehicles = new ArrayList<>(3);
        Random r = new Random(new Date().getTime());
        vehicles.add(new Vehicle(latch,r,2));
        vehicles.add(new Vehicle(latch,r,1));
        vehicles.add(new Vehicle(latch,r,3));
        vehicles.forEach(Vehicle::prepare);

        do{
            System.out.println("waiting for vehicles to prepare...");
            Thread.sleep(2000);
        }while (latch.getCount() != 1);
        System.out.println("all vehicles are ready to race");
        latch.countDown();
    }
}

class Vehicle implements Runnable{
    CountDownLatch latch;
    int prepareTime, number;
    Thread thread;

    public Vehicle(CountDownLatch latch, Random r, int number) {
        this.latch = latch;
        prepareTime = r.nextInt(7000);
        this.number = number;
        thread = new Thread(this,"vehicle #" + number);
    }

    public void prepare(){
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("vehicle #" + number + " started preparation, prepare time:" + prepareTime);
        try {
            Thread.sleep(prepareTime);
            latch.countDown();

            System.out.println("vehicle #" + number + " has been prepared and waits for start signal");

            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("vehicle #" + number + " has started the race");
    }
}
