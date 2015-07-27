package ch22.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamOperator {
    public static void viewInputStream(InputStream os) throws IOException {
        int c;
        while ((c = os.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void writeToOutputStream(String text,OutputStream os) throws IOException{
        os.write(text.getBytes());
    }
}
