package ch19;

import java.util.Scanner;

public class ScannerConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfVals = 0;
        double valsSum = 0;

        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                numOfVals++;
                valsSum += sc.nextDouble();
            }
            else {
                String nextLn = sc.next();
                if (nextLn.equals("done"))
                    System.out.println("Average: " + (valsSum / numOfVals) + ".");
                else
                    System.out.println("Unknown command.");
                return;
            }
        }

    }
}
