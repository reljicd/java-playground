package challenges;

import java.util.*;

class SpiralIterator {

    static List<Integer> spiralIterator1(List<Integer> numbers) {
        List<Integer> spiraledNumbers = new ArrayList<>();
        Deque<Integer> numbersDeque = new ArrayDeque<>(numbers);
        while (true) {
            try {
                spiraledNumbers.add(numbersDeque.removeFirst());
                spiraledNumbers.add(numbersDeque.removeLast());
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return spiraledNumbers;
    }

    static List<Integer> spiralIterator2(List<Integer> numbers) {
        List<Integer> spiraledNumbers = new ArrayList<>();
        int halfPointIndex = (numbers.size() % 2 == 1) ? numbers.size() / 2 + 1 : numbers.size() / 2;
        for (int i = 0; i < halfPointIndex; i++) {
            spiraledNumbers.add(numbers.get(i));
            if (numbers.size() % 2 == 1 && i == halfPointIndex - 1) break;
            spiraledNumbers.add(numbers.get(numbers.size() - 1 - i));
        }
        return spiraledNumbers;
    }

}
