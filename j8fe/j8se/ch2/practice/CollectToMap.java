package j8se.ch2;

import j8se.ch2.auxiliary.Message;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectToMap {
    public static void main(String[] args) {
        getMessages(5).stream().collect(
                Collectors.toMap(Message::getId, Message::getText)
        ).entrySet().forEach(System.out::println);

        getMessages(5).stream().collect(
                Collectors.toMap(Message::getId, Function.identity())
        ).entrySet().forEach(System.out::println);

        List<Message> messages = getMessages(3);
        messages.add(new Message(messages.get(2).getId(), messages.get(2).getText()));
        messages.get(messages.size() - 1).setText("Message X");
        messages.forEach(System.out::println);

        messages.stream()
                .collect(Collectors.toMap(
                        Message::getId, Message::getText,
                        (exst, nval) -> nval
                )).entrySet().forEach(System.out::println);

        /*Map<Integer,Set<String>> map = messages.stream()
                .collect(Collectors.toMap(
                        Message::getId,
                        Message::getText,
                        (exst,newv) ->{
                            Set<String> mrgd = new HashSet<>(exst);
                            mrgd.addAll(newv);
                            return mrgd;
                        }

                ));*/
    }

    private static List<Message> getMessages(int amount) {
        return Stream
                .iterate(new Message(1, "Message 1"), CollectToMap::createNext)
                .limit(amount).collect(Collectors.toList());
    }

    private static Message createNext(Message previous) {
        return new Message(previous.getId() + 1,
                "Message " + (previous.getId() + 1));
    }
}