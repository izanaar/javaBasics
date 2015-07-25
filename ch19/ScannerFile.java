package ch19;

import auxillary.CollectionsViewer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerFile {
    public static void main(String[] args) throws IOException {
        int count = 0;
        double sum = 0;

        try(FileWriter fw = new FileWriter("test.txt")){
            fw.write("2,2,3.5,5,2,1 done");
        }

        try(FileReader fr = new FileReader("test.txt")){
            char[] chars = new char[fr.read()];
            fr.read(chars);
            CollectionsViewer.viewArray(chars);
        }



        try(Scanner sc = new Scanner(new FileReader("test.txt"))) {
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                if (sc.hasNextDouble()) {
                    double x = sc.nextDouble();
                    count++;
                    sum += x;
                    System.out.println("read double: " + x);
                } else {
                    String nextLn = sc.next();
                    if (nextLn.equals("done"))
                        System.out.println("Average: " + (sum / count) + ".");
                    else
                        System.out.println("Unknown command.");
                    sc.close();
                    return;
                }
            }
        }

    }
}
