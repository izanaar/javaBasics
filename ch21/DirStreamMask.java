package ch21;

import auxillary.CollectionsViewer;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirStreamMask {
    public static void main(String[] args) {
        Path path = Paths.get(CollectionsViewer.testDirPath);

        try(DirectoryStream<Path> dirStr = Files.newDirectoryStream(path,
                "{subDir[1-3]*,test*,???[1-9]}")){
            dirStr.forEach(dir ->{
                System.out.println(dir);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
