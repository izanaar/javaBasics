package ch21;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class DirStream {
    public static void main(String[] args) {
        try(DirectoryStream<Path> dir = Files.
                newDirectoryStream(Paths.get("/home/work/java/IOTest"), "nio*")){
            System.out.println("Directory by path: \"" + dir + "\" contains");
            dir.forEach(path -> {
                try {
                    BasicFileAttributes attr = Files.readAttributes(path,BasicFileAttributes.class);
                    if(attr.isDirectory()) {
                        String fileName = path.getFileName().toString();
                        System.out.print((attr.isDirectory() ? "Directory: " : "File: ") + fileName + "; ");
                        System.out.println("created on: " + attr.creationTime());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
