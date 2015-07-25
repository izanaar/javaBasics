package ch20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyInputStream {
    public static void main(String[] args) throws FileNotFoundException {
        try (FileInputStream fis = new FileInputStream("/home/work/java/IOTest/respond")) {
//            p("Available bytes: " + fis.available() + ", kBytes: " + fis.available() / 1024.0 + ".");
//            p("First 20 characters: ");
//            byte[] chrs = new byte[20];
//            fis.read(chrs);
//            p(chrs);
//            viewAvailableBytes(fis);
//            p("Skipping 20 bytes...");
//            fis.skip(20);
//            viewAvailableBytes(fis);
//            fis.read(chrs);
//            p(chrs);
//            p("Rewriting last 10 bytes...");
//            fis.read(chrs, 10, 10);
//            p(chrs);
//            p("Reading last 20 bytes...");
//            fis.skip(fis.available() - 20);
//            fis.read(chrs);
//            p(chrs);
//            viewAvailableBytes(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
