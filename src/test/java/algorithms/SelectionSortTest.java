package algorithms;

import org.junit.Test;

import static utils.TestUtils.testSortingMethod;

public class SelectionSortTest {

    @Test
    public void selectionSort1() {
        testSortingMethod(SelectionSort::selectionSort1);
    }

    @Test
    public void selectionSort2() {
        testSortingMethod(SelectionSort::selectionSort2);
    }

    @Test
    public void selectionSort3() {
        testSortingMethod(SelectionSort::selectionSort3);
    }
}