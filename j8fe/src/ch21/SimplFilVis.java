package ch21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class SimplFilVis {
    public static void main(String[] args) {
        try {
            Files.walkFileTree(Paths.get("/home/work/java/IOTest"),new FileVis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileVis implements FileVisitor<Path>{
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return null;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return null;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return null;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return null;
    }
}

