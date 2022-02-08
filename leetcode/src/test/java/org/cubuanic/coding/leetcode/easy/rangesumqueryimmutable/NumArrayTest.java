package org.cubuanic.coding.leetcode.easy.rangesumqueryimmutable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumArrayTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(
                new int[]{-2, 0, 3, -5, 2, -1},
                new int[][]{{0, 2}, {2, 5}, {0, 5}},
                new int[]{1, -1, -3}
            )
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void sumRangeSolution1(int[] nums, int[][] ranges, int[] expected) {
        checkSolution(new NumArray1(nums), ranges, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void sumRangeSolution2(int[] nums, int[][] ranges, int[] expected) {
        checkSolution(new NumArray2(nums), ranges, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void sumRangeSolution3(int[] nums, int[][] ranges, int[] expected) {
        checkSolution(new NumArray3(nums), ranges, expected);
    }

    private void checkSolution(NumArray solution, int[][] ranges, int[] expected) {
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int expectedResult = expected[i];
            assertEquals(expectedResult, solution.sumRange(range[0], range[1]));
        }
    }
}
