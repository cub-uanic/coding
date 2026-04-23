package cub.leetcode.easy.missingnumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{3, 0, 1}, 2),
            Arguments.of(new int[]{0, 1}, 2),
            Arguments.of(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8),
            Arguments.of(new int[]{0}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void missingNumber(int[] input, int expected) {
        Solution solution = new Solution();
        assertEquals(expected, solution.missingNumber(input));
    }
}
