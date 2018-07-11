package algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class QuickSort {

    static List<Integer> quickSort1(List<Integer> intList) {

        if (intList.size() <= 1) return intList;

        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (Integer integer : intList) {
            if (integer < intList.get(0)) less.add(integer);
            if (integer.equals(intList.get(0))) equal.add(integer);
            if (integer > intList.get(0)) greater.add(integer);
        }

        return Stream.of(quickSort1(less), quickSort1(equal), quickSort1(greater))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    static List<Integer> quickSort2(List<Integer> intList) {

        if (intList.size() <= 1) return intList;

        List<Integer> sortedList = new ArrayList<>();

        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (Integer integer : intList) {
            if (integer < intList.get(0)) less.add(integer);
            if (integer.equals(intList.get(0))) equal.add(integer);
            if (integer > intList.get(0)) greater.add(integer);

        }

        sortedList.addAll(quickSort2(less));
        sortedList.addAll(quickSort2(equal));
        sortedList.addAll(quickSort2(greater));

        return sortedList;
    }

    static List<Integer> quickSort3(List<Integer> intList) {

        if (intList.size() <= 1) return intList;

        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        intList.forEach(integer -> {
            if (integer < intList.get(0)) less.add(integer);
            if (integer.equals(intList.get(0))) equal.add(integer);
            if (integer > intList.get(0)) greater.add(integer);
        });

        return Stream.of(quickSort3(less), quickSort3(equal), quickSort3(greater))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}
