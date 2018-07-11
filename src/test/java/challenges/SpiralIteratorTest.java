package challenges;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class SpiralIteratorTest {

    @Test
    public void spiralIterator1() {
        spiralIterator(SpiralIterator::spiralIterator1);
    }

    @Test
    public void spiralIterator2() {
        spiralIterator(SpiralIterator::spiralIterator2);
    }

    private static void spiralIterator(UnaryOperator<List<Integer>> spiralIteratorMethod) {
        assertThat(spiralIteratorMethod.apply(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(Arrays.asList(1, 6, 2, 5, 3, 4));
        assertThat(spiralIteratorMethod.apply(Arrays.asList(1, 2, 3, 4, 5, 6, 7))).isEqualTo(Arrays.asList(1, 7, 2, 6, 3, 5, 4));
    }
}