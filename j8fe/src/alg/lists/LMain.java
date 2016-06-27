package alg.lists;

public class LMain {

    public static void main(String[] args) {
        MyLinkedList<String> myList = new MyLinkedList<>();

        myList.insertFirst(new ListItem<>("First"));
        myList.insertFirst(new ListItem<>("Second"));
        myList.insertFirst(new ListItem<>("Third"));


        System.out.println(myList.find(new ListItem<>("Fourth")));

        int k = 2;
    }

}
