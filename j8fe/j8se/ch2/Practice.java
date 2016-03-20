package j8se.ch2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(10);

        words.add("thermal");
        words.add("internal");
        words.add("ancestor");
        words.add("acomplished");

        Predicate<String> filter = word -> word.contains("i");

        long count = words.stream().filter(filter).count();

        words.stream().filter(filter).forEach(System.out::println);


        String wordsx[] = words.stream().filter(filter).toArray(String[]::new);

        Arrays.stream(wordsx).forEach(word -> System.out.println("From array based word stream: " + word));

        Path path = Paths.get("/home/traum/test");

        System.out.println(Files.isRegularFile(Paths.get("/home/traun")));

        Stream<Integer> lengths;

        try (Stream<String> fileLines = Files.lines(path)){
            lengths = fileLines.map(String::length);
            lengths.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream<Double> randoms = Stream.generate(Math::random).limit(5).peek(item -> System.out.println("Reqired element: " + item));

        randoms.forEach(System.out::println);



    }
}
