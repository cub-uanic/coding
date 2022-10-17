package cub.leetcode.easy.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(9, new int[]{-1, 0, 3, 5, 9, 12}, 4),
            Arguments.of(2, new int[]{-1, 0, 3, 5, 9, 12}, -1),
            Arguments.of(5, new int[]{5}, 0),
            Arguments.of(5, new int[]{2, 5}, 1),
            Arguments.of(2, new int[]{2, 5}, 0),
            Arguments.of(5, new int[]{2, 3, 5}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void binarySearchTest(int inputTarget, int[] inputData, int expected) {
        Solution solution = new Solution();
        assertEquals(expected, solution.search(inputData, inputTarget));
    }
}
