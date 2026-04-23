package cub.leetcode.easy.countingbits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(0, new int[]{0}),
            Arguments.of(2, new int[]{0, 1, 1}),
            Arguments.of(5, new int[]{0, 1, 1, 2, 1, 2}),
            Arguments.of(7, new int[]{0, 1, 1, 2, 1, 2, 2, 3}),
            Arguments.of(8, new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void countBits(int input, int[] expected) {
        Solution solution = new Solution();
        assertArrayEquals(expected, solution.countBits(input));
    }
}
