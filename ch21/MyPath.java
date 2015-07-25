package ch21;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MyPath {
    public static void main(String[] args) {
        Path path = Paths.get("/home/work/java/IOTest/trololey"),
                sepPath = Paths.get("/java/IOTest/trololey");


        path.iterator().forEachRemaining(p ->{
            if(p.equals(path.getFileName()))
                System.out.println("/" + p);
            else
                System.out.print(p);
        });


        System.out.println(sepPath.isAbsolute()? "Path is absolute" : "Path is not absolute");
        System.out.println(path.isAbsolute()? "Path is absolute" : "Path is not absolute");

    }
}
