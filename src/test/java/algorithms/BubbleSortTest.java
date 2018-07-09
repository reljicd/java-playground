package algorithms;

import org.junit.Test;

import static utils.TestUtils.testSortingMethod;

public class BubbleSortTest {

    @Test
    public void bubbleSort1() {
        testSortingMethod(BubbleSort::bubbleSort1);
    }
}