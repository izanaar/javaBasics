package j8se.ch1;

import java.io.File;
import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        File file = new File("/home/traum");
        Arrays.asList(file.listFiles((File dir, String name) ->
                name.contains(".tar.gz")
        )).forEach(System.out::println);
    }
}
