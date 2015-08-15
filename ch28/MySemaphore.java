package ch28;

import java.util.concurrent.Semaphore;

public class MySemaphore {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);
        System.out.println("Available before relase: " + s.availablePermits());
        s.release(4);
        System.out.println("Available after relase: " + s.availablePermits());
        System.out.println(9%4);
    }
}
