package ch21;

import auxillary.CollectionsViewer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttrs {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(CollectionsViewer.testDirPath);

        BasicFileAttributes attrs = Files.readAttributes(path,BasicFileAttributes.class);
        System.out.println(path.getFileName());
    }
}
