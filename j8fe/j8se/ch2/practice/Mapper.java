package j8se.ch2.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapper {
    public static void main(String[] args) {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> localeNames = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayLanguage,
                        l->l.getDisplayLanguage(l),
                        (exVal, newVal) -> exVal
                )
        );

        locales = Stream.of(Locale.getAvailableLocales());

        Map<String, Set<String>> countryLanguageSets = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a,b) ->{
                            Set<String> r = new HashSet<>(a);
                            r.addAll(b);
                            return r;
                        }
                )
        );



        Stream<String> stringStream = Arrays.stream(new String[]{"en-ru","en-cn","ru-en"});

        Map<String, Set<String>> stringSets = stringStream.collect(
                Collectors.toMap(
                        s -> s.substring(0, s.indexOf('-')),
                        l -> Collections.singleton(l.substring(l.indexOf('-') + 1)),
                        (a,b) ->{
                            Set<String> r = new HashSet<>(a);
                            r.addAll(b);
                            return r;
                        }
                )
        );

    }
}
