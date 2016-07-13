package alg.arrays;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyArrayTest {

    private MyArray array;

    @Before
    public void setUp() throws Exception {
        array = new MyArray();
    }

    @Test
    public void testBubbleSort() throws Exception {
        int[] sortedArray = Arrays.copyOf(array.getValues(), array.getValues().length);
        Arrays.sort(sortedArray);

        assertFalse(Arrays.equals(array.getValues(), sortedArray));
        array.sortBubble();

        assertTrue(Arrays.equals(array.getValues(), sortedArray));
    }

    @Test
    public void testSortSelect() throws Exception {
        int[] sortedArray = Arrays.copyOf(array.getValues(), array.getValues().length);
        Arrays.sort(sortedArray);

        assertFalse(Arrays.equals(array.getValues(), sortedArray));
        array.sortSelect();

        assertTrue(Arrays.equals(array.getValues(), sortedArray));
    }

    @Test
    public void testSortInsert() throws Exception {
        int[] sortedArray = Arrays.copyOf(array.getValues(), array.getValues().length);
        Arrays.sort(sortedArray);

        assertFalse(Arrays.equals(array.getValues(), sortedArray));
        array.sortInsert(0);

        assertTrue(Arrays.equals(array.getValues(), sortedArray));
    }

    @Test
    public void testShallSort() throws Exception {
        int[] sortedArray = Arrays.copyOf(array.getValues(), array.getValues().length);
        Arrays.sort(sortedArray);

        assertFalse("Sorted and unsorted arrays are equal.", Arrays.equals(array.getValues(), sortedArray));
        array.sortShell();

        assertTrue("Sorted array isn't equal to shape.", Arrays.equals(array.getValues(), sortedArray));
    }
}