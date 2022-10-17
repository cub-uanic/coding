package cub.leetcode.medium.dailytemperatures;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
            Arguments.of(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}),
            Arguments.of(new int[]{30, 60, 90}, new int[]{1, 1, 0}),
            Arguments.of(new int[]{13, 12, 15, 11, 9, 12, 16}, new int[]{2, 1, 4, 2, 1, 1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void dailyTemperaturesSolution1(int[] input, int[] expected) {
        checkSolution(new Solution1(), input, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void dailyTemperaturesSolution2(int[] input, int[] expected) {
        checkSolution(new Solution2(), input, expected);
    }

    private void checkSolution(Solution solution, int[] input, int[] expected) {
        assertArrayEquals(expected, solution.dailyTemperatures(input));
    }
}
