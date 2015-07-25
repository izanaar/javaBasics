package ch18;

import java.util.Comparator;
import java.util.TreeMap;

public class IComparator{
    public static void main(String[] args) {
        Comparator<String> stringComparator =
                (str1,str2) -> str1.substring(str1.lastIndexOf(' ')).compareTo(str2.substring(str2.lastIndexOf(' '))),
        auxillaryComparator = (str1,str2) -> str1.compareTo(str2);


        TreeMap<String,Double> clients = new TreeMap<>(stringComparator.thenComparing(auxillaryComparator.reversed()));

        clients.put("Джон Доу", 3434.00);
        clients.put("Том Смит",123.22);
        clients.put("Джейн Бейкер", 1378.00);
        clients.put("Тод Халл", 99.22);
        clients.put("Ральф Смит", -19.23);


        clients.forEach((str, dbl) -> {
            System.out.println("Name: " + str + ", funds: " + dbl);
        });
    }
}
