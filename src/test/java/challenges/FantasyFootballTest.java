package challenges;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class FantasyFootballTest {

    @Test
    public void calculateScore() {
        assertThat(FantasyFootball.calculateScore(Arrays.asList(1, 1, 1), Arrays.asList(1, 0, 1))).isEqualTo(1);
        assertThat(FantasyFootball.calculateScore(Arrays.asList(1, 1, 1), Arrays.asList(1, 1, 1))).isEqualTo(3);
        assertThat(FantasyFootball.calculateScore(Arrays.asList(0, 0, 1), Arrays.asList(1, 1, 1))).isEqualTo(0);
        assertThat(FantasyFootball.calculateScore(Arrays.asList(1, 1, 1, 1, 1, 1, 1), Arrays.asList(1, 1, 1, 1, 1, 1, 1))).isEqualTo(7);
        assertThat(FantasyFootball.calculateScore(Arrays.asList(1, 1, 1, 1, 1, 1, 1), Arrays.asList(1, 1, 1, 1, 1, 1, 0))).isEqualTo(6);
        assertThat(FantasyFootball.calculateScore(Arrays.asList(1, 1, 1, 1, 1, 1, 0), Arrays.asList(1, 1, 1, 1, 1, 0, 0))).isEqualTo(5);
        assertThat(FantasyFootball.calculateScore(Arrays.asList(1, 1, 0, 1, 1, 1, 0), Arrays.asList(1, 1, 1, 1, 0, 1, 0))).isEqualTo(3);
        assertThat(FantasyFootball.calculateScore(Arrays.asList(1, 1, 0, 0, 1, 1, 0), Arrays.asList(1, 0, 0, 0, 1, 1, 1))).isEqualTo(4);
        assertThat(FantasyFootball.calculateScore(Arrays.asList(1, 0, 0, 0, 1, 1, 0), Arrays.asList(1, 1, 1, 1, 1, 1, 1))).isEqualTo(1);
        assertThat(FantasyFootball.calculateScore(Arrays.asList(1, 1, 0, 0, 1, 1, 0), Arrays.asList(0, 0, 1, 1, 1, 1, 1))).isEqualTo(0);
    }
}