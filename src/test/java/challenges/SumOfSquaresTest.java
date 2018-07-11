package challenges;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumOfSquaresTest {

    @Test
    public void sumOfSquares() {
        assertThat(SumOfSquares.sumOfSquares(5)).isTrue();
        assertThat(SumOfSquares.sumOfSquares(10)).isTrue();
        assertThat(SumOfSquares.sumOfSquares(17)).isTrue();
        assertThat(SumOfSquares.sumOfSquares(18)).isTrue();
        assertThat(SumOfSquares.sumOfSquares(20)).isTrue();
        assertThat(SumOfSquares.sumOfSquares(6)).isFalse();
        assertThat(SumOfSquares.sumOfSquares(11)).isFalse();
        assertThat(SumOfSquares.sumOfSquares(19)).isFalse();
        assertThat(SumOfSquares.sumOfSquares(21)).isFalse();
        assertThat(SumOfSquares.sumOfSquares(22)).isFalse();
    }
}