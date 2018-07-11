package challenges;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A  B   C   D
 * B     D
 * D
 * <p>
 * 0 = Left team won
 * 1 = Right team won
 * <p>
 * prediction 101
 * actual 101
 * score = 3
 * <p>
 * ====================
 * <p>
 * prediction: 111
 * actual: 101
 * score: 1
 * <p>
 * ====================
 * <p>
 * calculateScore(prediction, actual) => return score
 * <p>
 * calculateScore([1,1,0,0,1,1,0], [1,0,0,0,1,1,1])
 * <p>
 * pred: 1100 11 0
 * actual: 1000 11 1
 * score: 4
 * <p>
 * 11 v.s. 11
 * if agree in this round, look at last round
 * else disagree
 * <p>
 * Number Teams: 2^X
 * <p>
 * Size of first round: Teams/2
 * Size of second round: Teams/4
 * <p>
 * NumberOfBits = T/2 + T/4 + T/8 ....
 * <p>
 * 111 => 4 teams
 * T = 4  NumberBits = 3
 * T = 8  NumberBits = 7
 * <p>
 * Number bits to represent match: Teams - 1
 * <p>
 * 2^0 + 2^1 + 2^2...
 * <p>
 * X A  Y B  Z C W D
 * A   B     C  D
 * B         D
 * D
 */
class FantasyFootball {

    static int calculateScore(List<Integer> predictions, List<Integer> actuals) {
        List<Boolean> scores = IntStream.range(0, predictions.size())
                .mapToObj(i -> predictions.get(i).equals(actuals.get(i)))
                .collect(Collectors.toList());

        // Invert scores, construct binary tree
        Collections.reverse(scores);

        // For each node check its children if they are both True,
        // and if not, set score of that node to False.
        // Do it bottoms up
        for (int i = scores.size() / 2 - 1; i >= 0; i--) {
            scores.set(i, scores.get(i) && scores.get(2 * i + 1) && scores.get(2 * i + 2));
        }

        return scores.stream().mapToInt(bool -> bool ? 1 : 0).sum();
    }

}
