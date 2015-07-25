package ch18;

import java.util.*;

public class IIterator {
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();

        list.add("D");
        list.add("E");
        list.add("A");
        list.add("B");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("C");

        System.out.println("Unsorted collection: ");
        showCollection(list);


        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("Reversly sorted collection: ");
        showCollection(list);


    }

    private static void showCollection(Collection collection){
        Iterator iterator = collection.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + "\t");
        System.out.println();
    }
}
