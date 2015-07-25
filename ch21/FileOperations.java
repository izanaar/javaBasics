package ch21;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class FileOperations {
    public static void main(String[] args) {
        Path txtFile = Paths.get("/home/work/java/IOTest/nio_test");
        try {
            PrintStream ous =
                    new PrintStream(Files.newOutputStream(txtFile,StandardOpenOption.CREATE));
            ous.println(new Date());


            byte[] hwBytes;
            InputStream is = Files.newInputStream(txtFile,StandardOpenOption.DELETE_ON_CLOSE);

            hwBytes = new byte[is.available()];
            is.read(hwBytes);

            System.out.println(new String(hwBytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
