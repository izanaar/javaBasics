package j8se.ch2;

import java.util.Optional;
import java.util.stream.Stream;

public class PracticeAggregate {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("Tempest", "keep","was","merely","a","setback");

        //Optional<String> sentence = words.reduce(String::concat);
        Optional<String> sentence = words.reduce((str1, str2) -> str1 + " " + str2);

        sentence.ifPresent(System.out::println);
    }
}
