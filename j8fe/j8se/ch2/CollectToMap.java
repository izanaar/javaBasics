package j8se.ch2;

import j8se.ch2.auxiliary.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectToMap {
    public static void main(String[] args) {
        List<Message> messages = createEntries(5);
        messages.forEach(System.out::println);
    }

    private static List<Message> createEntries(int amount) {
        return Stream
                .iterate(new Message(1, "Message 1"),CollectToMap::createNext)
                .limit(amount).collect(Collectors.toList());
    }

    private static Message createNext(Message previous) {
        return new Message(previous.getId() + 1,
                "Message " + (previous.getId() + 1));
    }
}