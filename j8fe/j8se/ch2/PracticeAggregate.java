package j8se.ch2;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class PracticeAggregate {
    public static void main(String[] args) {

        BinaryOperator<String> accumulatorWithSpaces = (str1,str2) -> str1 + " " + str2;

        String[] wordsArr = new String[]{"Tempest", "keep", "was", "merely", "a", "setback"};

        Stream<String> words = Arrays.stream(wordsArr).peek((str1) -> System.out.println("Requiring value " + str1));

        //Optional<String> sentence = words.reduce(String::concat);
        Optional<String> sentence = words.reduce(accumulatorWithSpaces);

        sentence.ifPresent(System.out::println);

        Optional<Integer> length = Arrays.stream(wordsArr).map(String::length).reduce(Integer::sum);

        length.ifPresent(val-> System.out.println("Sentence's length by mat/string: " + val));

        Arrays.stream(wordsArr).reduce(String::concat)
                .map(String::length)
                .ifPresent( val->  System.out.println("Sentence's length by string length: " + val));
    }
}
