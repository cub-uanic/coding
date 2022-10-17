package cub.leetcode.easy.maximumsubarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{1}, 1),
            Arguments.of(new int[]{-1}, -1),
            Arguments.of(new int[]{1, 2}, 3),
            Arguments.of(new int[]{2, 1}, 3),
            Arguments.of(new int[]{-1, -2}, -1),
            Arguments.of(new int[]{-2, -1}, -1),
            Arguments.of(new int[]{-1, 1, 2}, 3),
            Arguments.of(new int[]{-1, 2, 1}, 3),
            Arguments.of(new int[]{1, 2, -1}, 3),
            Arguments.of(new int[]{2, 1, -1}, 3),
            Arguments.of(new int[]{-1, 2}, 2),
            Arguments.of(new int[]{2, -1}, 2),
            Arguments.of(new int[]{5, 4, -1, 7, 8}, 23),
            Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
            Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 400}, 401)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void maxSubArray(int[] input, int expected) {
        Solution solution = new Solution();
        assertEquals(expected, solution.maxSubArray(input));
    }
}
