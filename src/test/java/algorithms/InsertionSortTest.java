package algorithms;

import org.junit.Test;

import static utils.TestUtils.testSortingMethod;

public class InsertionSortTest {

    @Test
    public void insertionSort1() {
        testSortingMethod(InsertionSort::insertionSort1);
    }

    @Test
    public void insertionSort2() {
        testSortingMethod(InsertionSort::insertionSort2);
    }
}