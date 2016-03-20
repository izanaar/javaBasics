package j8se.ch2;

import java.util.Arrays;
import java.util.stream.Stream;

public class PracticeFlatMap {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("Tempest keep ", "was merely ","a setback.");

        //Arrays.asList("text".split("")).forEach(System.out::println);

        //Stream<Stream<Character>> wordStreams = words.map(PracticeFlatMap::toCharStream);

        Stream<Character> characterStream = words.flatMap(PracticeFlatMap::toCharStream);

        System.out.println(characterStream.count());


       // wordStreams.forEach(characterStream -> characterStream.forEach(System.out::print));

    }


    private static Stream<Character> toCharStream(String line){
        return Stream.of(line.split("")).map(letter -> letter.charAt(0));
    }
}
