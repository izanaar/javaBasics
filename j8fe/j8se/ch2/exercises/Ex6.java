package j8se.ch2.exercises;

import java.util.stream.Stream;

public class Ex6 {
    public static void main(String[] args) {
        toCharStream("Tempest keep was merely a setback").forEach(System.out::print);
    }

    private static Stream<Character> toCharStream(String s) {
        return Stream.iterate(0, val -> ++val).limit(s.length()).map(s::charAt);
    }
}
