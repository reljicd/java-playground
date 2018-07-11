package challenges;

import org.apache.commons.math3.util.Combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Given an array of n positive integers, find the number of sub arrays
 * such that product of the elements of those sub arrays are less than k.
 * <p>
 * Example:
 * Arr= {2, 3, 6} k=10
 * No of such sub arrays= 4
 * <p>
 * https://www.careercup.com/question?id=5768044260360192
 */
class NumSubArraysLessThanK {

    static int numSubArraysLessThanK(List<Integer> numbers, int k) {
        return (int) IntStream.rangeClosed(1, numbers.size())
                .mapToObj(i -> new Combinations(numbers.size(), i))
                .flatMap(combinations -> StreamSupport.stream(combinations.spliterator(), false))
                .map(indexArray -> {
                    List<Integer> numbersCombination = new ArrayList<>();
                    for (int index : indexArray) {
                        numbersCombination.add(numbers.get(index));
                    }
                    return numbersCombination;
                })
                .filter(numbersCombination -> numbersCombination.stream().reduce(1, (a, b) -> a * b) < k)
                .count();
    }
}
