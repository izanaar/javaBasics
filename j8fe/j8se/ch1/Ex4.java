package j8se.ch1;

import java.io.File;
import java.util.Arrays;

public class Ex4 {
    public static void main(String[] args) {
        File dir = new File("/home/traum");

        File[] content = dir.listFiles();

        if (content == null) {
            return;
        }

        Arrays.sort(content,(file1,file2) -> {
            if(!file1.isDirectory() && file2.isDirectory()){
                return 1;
            }else if(file1.isDirectory() && !file2.isDirectory()){
                return -1;
            }else{
               return (file1.getName().compareToIgnoreCase(file2.getName()));
            }
        });

        Arrays.asList(content).forEach(System.out::println);

    }
}
