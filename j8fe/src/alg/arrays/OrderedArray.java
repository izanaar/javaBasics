package alg.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class OrderedArray {

    private int[] values;
    private int length;

    public OrderedArray(int length) {
        /*Random r = new Random();
        IntSupplier randSupplier = () -> r.nextInt(100);

        values = IntStream.generate(randSupplier).limit(length).toArray();*/
        this.length = length;


        values = new int[length];
        values[0] = 55;
        values[1] = 48;
        values[2] = 51;
        values[3] = 24;
        values[4] = 21;
        values[5] = 44;
        values[6] = 13;
        values[7] = 9;
        values[8] = 17;
        values[9] = 32;
        values[10] = 18;
        values[11] = 4;
        values[12] = 7;
        values[13] = 28;
        values[14] = 39;
        values[15] = 2;
    }

    public int find(int value) {
        int index;

        int startIndex = 0,
                endIndex = length - 1;

        do {
            int mid = (startIndex + endIndex) / 2;
            if (values[mid] == value) {
                index = mid;
                break;
            } else {

                if (startIndex > endIndex) {
                    index = mid;
                    break;
                }

                if (value < values[mid]) {
                    endIndex = mid - 1;
                } else {
                    startIndex = mid + 1;
                }
            }
        } while (true);

        System.out.println("Index of " + value + " is " + index + ".");
        return index;
    }

    private void sort() {
        Arrays.sort(values);
    }

    private void sortBubble() {

        for (int i = 0; i < values.length; i++) {
            if (i == values.length - 1) {
                break;
            } else {
                if (values[i] > values[i + 1]) {
                    moveBubbleRight(i);
                    i = -1;
                }
            }
        }
    }

    private void moveBubbleRight(int index) {
        for (int i = index; i < values.length; i++) {
            if (i == values.length - 1) {
                return;
            } else {
                if (values[i] > values[i + 1]) {
                    replace(i, i + 1);
                } else {
                    return;
                }
            }
        }
    }

    private void sortSelect() {
        for (int i = 0; i < values.length; i++) {
            setMinToPosition(i);
        }
    }

    private void setMinToPosition(int position) {

        int minIndex = position;

        for (int i = position; i < values.length; i++) {
            if (values[i] < values[minIndex]) {
                minIndex = i;
            }
        }

        if (minIndex != position) {
            replace(position, minIndex);
        }
    }

    private void replace(int i1, int i2) {
        int buffer = values[i1];
        values[i1] = values[i2];
        values[i2] = buffer;
    }

    private int[] get() {
        return values;
    }

    public static void main(String[] args) {
        int length = 16;
        OrderedArray array = new OrderedArray(length);


        System.out.println("Unsorted array:");
        array.showValues();

        // array.sortBubble();
        array.sortSelect();
        System.out.println("Sorted array:");
        array.showValues();

        Random r = new Random();
        int index = 15;


    }

    private void showValues() {
        IntStream.of(values).forEach((value -> System.out.print(value + " ")));
        System.out.println();
    }
}
