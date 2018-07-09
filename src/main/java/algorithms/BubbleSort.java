package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BubbleSort {

    static List<Integer> bubbleSort1(List<Integer> intList) {
        List<Integer> intListForSorting = new ArrayList<>(intList);

        for (int j = intList.size(); j >= 0; j--) {
            for (int i = 1; i < j; i++) {
                if (intListForSorting.get(i - 1) > intListForSorting.get(i)) {
                    Collections.swap(intListForSorting, i - 1, i);
                }
            }
        }

        return intListForSorting;
    }
}
