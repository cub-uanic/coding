package org.cubuanic.coding.leetcode.easy.twosum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(-1, new int[]{0, 3, -3, 4, -1}, new int[]{4, 0}),
            Arguments.of(10, new int[]{2, 5, 5, 11}, new int[]{1, 2}),
            Arguments.of(9, new int[]{2, 7, 11, 15}, new int[]{0, 1}),
            Arguments.of(6, new int[]{3, 2, 4}, new int[]{1, 2}),
            Arguments.of(6, new int[]{3, 3}, new int[]{0, 1}),
            Arguments.of(-8, new int[]{-1, -2, -3, -4, -5}, new int[]{4, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void twoSumSolution1(int target, int[] input, int[] expected) {
        checkSolution(new Solution1(), target, input, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void twoSumSolution2(int target, int[] input, int[] expected) {
        checkSolution(new Solution2(), target, input, expected);
    }

    private void checkSolution(Solution solution, int target, int[] input, int[] expected) {
        int[] inputData = Arrays.copyOfRange(input, 0, input.length);
        int[] expectedData = Arrays.copyOfRange(expected, 0, expected.length);
        int[] actualData = solution.twoSum(inputData, target);
        Arrays.sort(expectedData);
        Arrays.sort(actualData);
        assertArrayEquals(expectedData, actualData);
    }
}
