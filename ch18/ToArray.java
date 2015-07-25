package ch18;

import java.util.ArrayList;

public class ToArray {
    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<>();
        for(int i = 1; i < 5; i++)
            arrList.add(Integer.toOctalString(i));

        String[] array = new String[6];
        array = arrList.toArray(array);

        for(int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
}
