package cub.leetcode.easy.singlenumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{2, 2, 1}, 1),
            Arguments.of(new int[]{4, 1, 2, 1, 2}, 4),
            Arguments.of(new int[]{1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void findDisappearedNumbersSolution1(int[] input, int expected) {
        checkSolution(new Solution1(), input, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findDisappearedNumbersSolution2(int[] input, int expected) {
        checkSolution(new Solution2(), input, expected);
    }

    private void checkSolution(Solution solution, int[] input, int expected) {
        assertEquals(expected, solution.singleNumber(input));
    }
}
