package j8se.ch2;

import java.util.Optional;

public class PracticeOptionalExtended {
    public static void main(String[] args) {
        Optional<String> test = //Optional.empty();
                                Optional.of("defined");

        System.out.println(test.orElseGet(() -> PracticeOptionalExtended.concatenate("foo", "bar")));
    }


    private static String concatenate(String str1, String str2){
        return str1 + str2;
    }
}
