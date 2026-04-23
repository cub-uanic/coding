package cub.leetcode.easy.containsduplicate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 1}, true),
            Arguments.of(new int[]{1, 2, 3, 4}, false),
            Arguments.of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void containsDuplicateSolution1(int[] input, boolean expected) {
        checkSolution(new Solution1(), input, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void containsDuplicateSolution2(int[] input, boolean expected) {
        checkSolution(new Solution2(), input, expected);
    }

    private void checkSolution(Solution solution, int[] input, boolean expected) {
        assertEquals(expected, solution.containsDuplicate(input));
    }
}
