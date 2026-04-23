package cub.leetcode.hard.firstmissingpositive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{-1, 4, 2, 1, 9, 10}, 3),
            Arguments.of(new int[]{1, 2, 0}, 3),
            Arguments.of(new int[]{3, 4, -1, 1}, 2),
            Arguments.of(new int[]{7, 8, 9, 11, 12}, 1),
            Arguments.of(new int[]{1, 3, 6, 4, 1, 2}, 5),
            Arguments.of(new int[]{1, 2, 3}, 4),
            Arguments.of(new int[]{-1, -3}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void firstMissingPositiveSolution1(int[] input, int expected) {
        checkSolution(new Solution1(), input, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void firstMissingPositiveSolution2(int[] input, int expected) {
        checkSolution(new Solution2(), input, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void firstMissingPositiveSolution3(int[] input, int expected) {
        checkSolution(new Solution3(), input, expected);
    }

    private void checkSolution(Solution solution, int[] input, int expected) {
        assertEquals(expected, solution.firstMissingPositive(input));
    }
}
