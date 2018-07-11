package challenges;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NumZeroSubsetsTest {

    @Test
    public void numZeroSubsets() {
        assertThat(NumZeroSubsets.numZeroSubsets(Arrays.asList(1, 2, -1, -2, 3))).isEqualTo(4);
        assertThat(NumZeroSubsets.numZeroSubsets(Arrays.asList(1, 1, 1, 1))).isEqualTo(0);
        assertThat(NumZeroSubsets.numZeroSubsets(Arrays.asList(1, 0, 1, 0))).isEqualTo(3);
        assertThat(NumZeroSubsets.numZeroSubsets(Arrays.asList(1, 0, 0, 0))).isEqualTo(7);
    }
}