package challenges;

import org.apache.commons.math3.util.Combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * How many subsets of a given array sum to zero?
 * <p>
 * https://www.careercup.com/question?id=5766413212975104
 */
class NumZeroSubsets {

    static int numZeroSubsets(List<Integer> numbers) {
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
                .filter(numbersCombination -> numbersCombination.stream().mapToInt(Integer::intValue).sum() == 0)
                .count();
    }

}
