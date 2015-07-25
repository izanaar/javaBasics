package ch21;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.*;
import java.util.Date;

//cpying files, using NIO
public class NIODemo8 {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("/home/work/java/IOTest/nio-x"),
                dest = Paths.get("/home/work/java/IOTest/nio-streams/nio-x-2");
        createTestFile(source);

        Files.copy(source,dest, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File '" + source + "' has been successfully copied to:\n" +
        dest);
    }

    static void createTestFile(Path location) throws IOException {
        PrintStream ps = new PrintStream(Files.newOutputStream(location, StandardOpenOption.CREATE));
        ps.println("This is test file. Creation time: ");
        ps.println(new Date());
    }
}
