package j8se.ch2.practice;

import j8se.ch2.auxiliary.Message;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeCollectors {

    public static void main(String[] args) {
        Stream<String> words = getSentenceFragments();

        System.out.println(words.collect(Collectors.joining()));

        List<String> sentenceParts = getSentenceFragments().collect(Collectors.toList());

        sentenceParts.forEach(System.out::println);

        Random rnd = new Random(new Date().getTime());

        Map<Integer, String> map = getSentenceFragments().map((text) -> new Message(rnd.nextInt(), text)).collect(Collectors.toMap(Message::getId, Message::getText));

        map.entrySet().stream().forEach(System.out::println);


    }

    private static Stream<String> getSentenceFragments() {
        return Stream.of("Tempest keep ", "was merely ", "a setback.");
    }

    private static Stream<String> getWords() {
        return getSentenceFragments().flatMap(s -> Arrays.stream(s.split(" ")));
    }
}
