package ch21;

import auxillary.CollectionsViewer;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class DirStreamFilter {
    public static void main(String[] args) {
        Path path = Paths.get(CollectionsViewer.testDirPath);

        DirectoryStream.Filter<Path> filter =(currPath)-> {
            BasicFileAttributes attr = Files.readAttributes(currPath,BasicFileAttributes.class);
            if(attr.isDirectory())
            return true;
            return false;
        };

        try(DirectoryStream<Path> dirStr = Files.newDirectoryStream(path,filter)){
            dirStr.forEach((currPath) -> System.out.println(currPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
