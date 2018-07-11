package challenges;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

/**
 * Determine whether a number is the sum of two squares.
 * <p>
 * Example:
 * 17 = 16 +1
 * <p>
 * https://www.careercup.com/question?id=5666912267665408
 */
class SumOfSquares {
    static boolean sumOfSquares(int number) {
        List<Integer> squares = IntStream.range(0, (int) ceil(sqrt(number))).map(i -> i * i)
                .boxed()
                .collect(Collectors.toList());

        for (int square : squares) {
            if (squares.contains(number - square)) return true;
        }

        return false;
    }
}
