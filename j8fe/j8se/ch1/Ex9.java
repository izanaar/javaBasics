package j8se.ch1;

public class Ex9 {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.println("Runnable 1 requires 2 seconds perform his operation.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Runnable 1 had failed.");
            }
            System.out.println("Runnable 1 has done hos operation.");
        };

        Runnable r2 = () -> {
            System.out.println("Runnable 2 requires 2 seconds perform his operation.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Runnable 1 had failed.");
            }
            System.out.println("Runnable 2 has done hos operation.");
        };

        Runnable returned = andThen(r1,r2);

        new Thread(returned).start();
    }

    private static Runnable andThen(Runnable r1, Runnable r2){
        Thread th1 = new Thread(r1,"thread 1"),
                th2 = new Thread(r2,"thread 2");

        th1.start();
        try {
            th1.join();
            th2.start();
            th2.join();
            return () -> System.out.println("Both your tasks have been completed, master!");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return () -> System.out.println("Aplogies, master. We have failed.");
        }
    }
}
