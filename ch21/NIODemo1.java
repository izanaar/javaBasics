package ch21;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIODemo1 {
    public static void main(String[] args) {
        Path path = Paths.get("/home/work/java/IOTest/nio1");
        try(PrintStream ps = new PrintStream(Files.newOutputStream(path, StandardOpenOption.APPEND));
            InputStream is = Files.newInputStream(path,StandardOpenOption.READ)){

            ps.println("Page 786");

            byte[] in;
            in = new byte[is.available()];

            is.read(in);

            System.out.println(new String(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
