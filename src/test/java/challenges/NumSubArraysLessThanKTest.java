package challenges;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NumSubArraysLessThanKTest {

    @Test
    public void numSubArraysLessThanK() {
        assertThat(NumSubArraysLessThanK.numSubArraysLessThanK(Arrays.asList(2, 3, 6), 10)).isEqualTo(4);
    }
}