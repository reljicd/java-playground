package algorithms;

import org.junit.Test;

import static utils.TestUtils.testSortingMethod;

public class SelectionSortTest {

    @Test
    public void selectionSort1() {
        testSortingMethod(SelectionSort::selectionSort1);
    }
}