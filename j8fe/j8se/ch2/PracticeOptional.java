package j8se.ch2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PracticeOptional {
    public static void main(String[] args) {

        List<String> processedOptionals = new ArrayList<>(10);

        Optional<String> emptyOptional = Optional.empty(),
                correctOptional = Optional.of("Correct optional");

        System.out.println("Adding result: " + correctOptional.map(processedOptionals::add).get());

        //correctOptional.ifPresent(processedOptionals::add);
        System.out.println(emptyOptional.map(processedOptionals::add).isPresent());

        processedOptionals.add(correctOptional.orElse("Empty optional"));
        processedOptionals.add(emptyOptional.orElseGet(PracticeOptional::provideString));

        processedOptionals.forEach(System.out::println);

    }

    private static String provideString(){
        return "Empty optional";
    }
}
