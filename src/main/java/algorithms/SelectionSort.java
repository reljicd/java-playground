package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;

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

    static List<Integer> selectionSort2(List<Integer> intList) {
        List<Integer> intListForSorting = new ArrayList<>(intList);

        for (int i = 0; i < intList.size(); i++) {
            int indexSmallest = IntStream.range(i, intList.size()).boxed()
                    .min(comparingInt(intListForSorting::get))
                    .get();
            Collections.swap(intListForSorting, i, indexSmallest);
        }

        return intListForSorting;
    }

    static List<Integer> selectionSort3(List<Integer> intList) {
        List<Integer> intListForSorting = new ArrayList<>(intList);

        IntStream.range(0, intList.size()).forEach(i -> {
            int indexSmallest = IntStream.range(i, intList.size()).boxed()
                    .min(comparingInt(intListForSorting::get))
                    .get();
            Collections.swap(intListForSorting, i, indexSmallest);
        });

        return intListForSorting;
    }
}