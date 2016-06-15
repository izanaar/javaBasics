package other;

import auxillary.Dosieu;

import java.util.TreeSet;

public class Tree {
    public static void main(String[] args) {
        TreeSet<Dosieu> dosieus = new TreeSet<>();

        Dosieu dosieu1 = new Dosieu("ds1","ds1note");
        Dosieu dosieu2 = new Dosieu("ds2","ds2note");

        dosieus.add(dosieu1);
        dosieus.add(dosieu2);

        System.out.println(dosieus.size());
    }
}
