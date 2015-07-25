package ch21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

//getting file attributes
public class NIODemo9 {
    public static void main(String[] args) {
        Path filePath = Paths.get("/home/work/java/IOTest/testfile");
        try {
            BasicFileAttributes attribs =
                    Files.readAttributes(filePath,BasicFileAttributes.class);
            System.out.println("File attributes: " + filePath);
            System.out.println("File creation time: " + attribs.creationTime());
            System.out.println(attribs.isDirectory() ? "is directory" : "is not directory");
            System.out.println(attribs.isRegularFile() ? "is regular file" : "is not regular file");
            System.out.println(attribs.isSymbolicLink() ? "is symbolic link" : "is not symbolic link");
            System.out.println("Last access time: " + attribs.lastAccessTime());
            System.out.println("Last modified: " + attribs.lastModifiedTime());
            System.out.println("Size: " + attribs.size() + "bytes");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
