package org.cubuanic.coding.leetcode.medium.uniquepaths;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(1, 1, 1),
            Arguments.of(2, 2, 2),
            Arguments.of(3, 7, 28),
            Arguments.of(3, 2, 3),
            Arguments.of(3, 3, 6),
            Arguments.of(23, 12, 193536720)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void uniquePaths_direct(int inputN, int inputM, int expected) {
        Solution solution = new Solution();
        assertEquals(expected, solution.uniquePaths(inputM, inputN));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void uniquePaths_reversed(int inputN, int inputM, int expected) {
        Solution solution = new Solution();
        assertEquals(expected, solution.uniquePaths(inputN, inputM));
    }
}
