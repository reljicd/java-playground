package algorithms;

import org.junit.Test;

import static utils.TestUtils.testSortingMethod;

public class QuickSortTest {

    @Test
    public void quickSort1() {
        testSortingMethod(QuickSort::quickSort1);
    }

    @Test
    public void quickSort2() {
        testSortingMethod(QuickSort::quickSort2);
    }

    @Test
    public void quickSort3() {
        testSortingMethod(QuickSort::quickSort3);
    }
}