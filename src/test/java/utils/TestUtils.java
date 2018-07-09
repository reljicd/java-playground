package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtils {

    private static final List<Integer> intList = Collections.unmodifiableList(
            IntStream.range(0, 100).boxed().collect(Collectors.toList()));

    public static void testSortingMethod(UnaryOperator<List<Integer>> sortingMethod) {
        List<Integer> intListForSorting = new ArrayList<>(intList);
        Collections.shuffle(intListForSorting);
        List<Integer> sortedIntList = sortingMethod.apply(intListForSorting);
        Collections.sort(intListForSorting);
        assertThat(sortedIntList).isEqualTo(intListForSorting);
    }
}
