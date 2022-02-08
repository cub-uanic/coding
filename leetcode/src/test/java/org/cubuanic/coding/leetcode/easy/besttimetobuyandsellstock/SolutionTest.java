package org.cubuanic.coding.leetcode.easy.besttimetobuyandsellstock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
            Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
            Arguments.of(new int[]{2, 1, 4}, 3),
            Arguments.of(new int[]{1, 2, 4}, 3),
            Arguments.of(new int[]{1, 4, 2}, 3),
            Arguments.of(new int[]{4, 1, 2}, 1),
            Arguments.of(new int[]{4, 2, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void maxProfit(int[] input, int expected) {
        Solution solution = new Solution();
        assertEquals(expected, solution.maxProfit(input));
    }
}
