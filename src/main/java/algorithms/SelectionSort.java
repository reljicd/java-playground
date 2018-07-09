package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SelectionSort {

    static List<Integer> selectionSort1(List<Integer> intList) {
        List<Integer> intListForSorting = new ArrayList<>(intList);

        for (int i = 0; i < intList.size(); i++) {
            int indexSmallest = i;
            for (int j = i; j < intList.size(); j++) {
                if (intListForSorting.get(j) < intListForSorting.get(indexSmallest)) {
                    indexSmallest = j;
                }
            }
            Collections.swap(intListForSorting, i, indexSmallest);
        }

        return intListForSorting;
    }
}