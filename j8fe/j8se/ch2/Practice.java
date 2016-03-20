package j8se.ch2;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(10);

        words.add("thermal");
        words.add("internal");
        words.add("ancestor");
        words.add("acomplished");

        long count = words.stream().count();
    }
}
