package j8se.ch1;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        File file = new File("/home/traum");
        Arrays.asList(file.listFiles(File::isDirectory)).forEach(System.out::println);
    }
}
