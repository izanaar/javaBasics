package ch21;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

//using NIO to read/write files throuth the threads
public class NIODemo7 {
    public static void main(String[] args) {
        Path source = Paths.get("/home/work/java/IOTest/nio-streams/nio-x-2"),
        dest = Paths.get("/home/work/java/IOTest/nio-streams/dstFile");

        try(OutputStream ous = Files.newOutputStream(dest, StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);
            InputStream is = Files.newInputStream(source,StandardOpenOption.READ)){

            int q;

            do{
                q = is.read();
                ous.write(q);

            }while (q!=-1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
