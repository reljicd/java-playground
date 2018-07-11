package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class InsertionSort {

    static List<Integer> insertionSort1(List<Integer> intList) {
        List<Integer> intListForSorting = new ArrayList<>(intList);

        for (int i = 1; i < intList.size(); i++) {
            int j = i;
            while (j > 0 && intListForSorting.get(j) < intListForSorting.get(j - 1)) {
                Collections.swap(intListForSorting, j, j - 1);
                j--;
            }
        }

        return intListForSorting;
    }

    static List<Integer> insertionSort2(List<Integer> intList) {
        List<Integer> intListForSorting = new ArrayList<>(intList);

        for (int i = 1; i < intList.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (intListForSorting.get(j) > intListForSorting.get(j - 1)) break;
                Collections.swap(intListForSorting, j, j - 1);
            }
        }

        return intListForSorting;
    }
}
