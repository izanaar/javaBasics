package ch13;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;

public class StringReaderPr {

    public static void main(String[] args) throws IOException {
        String string = "Tempest keep was merely a setback!";
        Reader reader = new StringReader(string);


        System.out.println("Source as bytes: " + Arrays.toString(string.getBytes()));
        System.out.print("String reader's read values: ");

        int value;
        while ((value = reader.read()) != -1) {
            System.out.print(value + " ");
        }
        System.out.println();
        reader.reset();

        readByChunks(reader, 4);
    }

    private static void readByChunks(Reader reader, int chunkSize) throws IOException {
        System.out.println("Reading value by " + chunkSize + " byte chunks:");
        int chunkCount = 0;
        char[] cbuf = new char[chunkSize];
        while (reader.read(cbuf, 0, chunkSize) != -1){
            System.out.println("Chunk " + chunkCount++ + ": " + Arrays.toString(cbuf));
            Arrays.fill(cbuf, (char) 0);
        }

    }
}
