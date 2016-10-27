package ch13;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class InputStreamPr {

    public static void main(String[] args) throws IOException {
        byte[] vals = new byte[]{24, 15, 27, 33};
        System.out.println("byte[]: " + Arrays.toString(vals));

        InputStream inputStream = new ByteArrayInputStream(vals);
        System.out.println("Input stream has been initialized.\nReading values: ");

        int val;
        while ((val = inputStream.read()) != -1) {
            System.out.print(val + " ");
        }
        System.out.println("\n");

        inputStream.reset();
        System.out.print("Input stream has been reset.\nReading first value: ");
        System.out.println(inputStream.read());
        System.out.println("Stream has been marked on position " + (vals.length - inputStream.available()));
        inputStream.mark(inputStream.available());

        System.out.println("Skipping " + inputStream.skip(vals.length - 1) + " values.");

        inputStream.reset();
        System.out.print("Input stream has been reset.\nReading first value: ");
        System.out.println(inputStream.read());
    }

}
