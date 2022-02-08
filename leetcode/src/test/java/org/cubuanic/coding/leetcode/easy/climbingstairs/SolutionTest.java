package org.cubuanic.coding.leetcode.easy.climbingstairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(1, 1),
            Arguments.of(2, 2),
            Arguments.of(3, 3),
            Arguments.of(4, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void climbStairs(int input, int expected) {
        Solution solution = new Solution();
        assertEquals(expected, solution.climbStairs(input));
    }
}
