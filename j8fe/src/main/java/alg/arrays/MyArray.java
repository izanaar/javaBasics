package alg.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class MyArray {

    private int[] values;
    private int length;

    public MyArray(int ... values){
        this.values = values;
        length = values.length;
    }

    public MyArray() {
            length = 10;

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
    }

    public int findBinary(int value) {
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

    void sortBubble() {

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

    void sortSelect() {
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

    void sortInsert(int startIndex) {
        for (int i = startIndex; i < values.length; i++) {
            int insertVal = values[i];
            int insertIndex = getPasteIndex(insertVal, i - 1);
            if (insertIndex == -1) {
                continue;
            }
            shiftArray(insertIndex, i);
            values[insertIndex] = insertVal;
        }

    }

    private int getPasteIndex(int value, int sortedEndIndex) {
        for (int i = 0; i <= sortedEndIndex; i++) {
            if (values[i] > value)
                return i;
        }
        return -1;
    }

    private void shiftArray(int start, int end) {
        System.arraycopy(values, start, values, start + 1, end - start);
    }

    public void sortShell() {

    }

    public void setValues(int[] values) {
        this.values = values;
        length = values.length;
    }

    private void showValues() {
        IntStream.of(values).forEach((value -> System.out.print(value + " ")));
        System.out.println();
    }

    public int[] getValues() {
        return values;
    }
}
