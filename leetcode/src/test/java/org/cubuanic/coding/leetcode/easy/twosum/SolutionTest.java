package org.cubuanic.coding.leetcode.easy.twosum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {-1, new int[]{0, 3, -3, 4, -1}, new int[]{4, 0}},
            {10, new int[]{2, 5, 5, 11}, new int[]{1, 2}},
            {9, new int[]{2, 7, 11, 15}, new int[]{0, 1}},
            {6, new int[]{3, 2, 4}, new int[]{1, 2}},
            {6, new int[]{3, 3}, new int[]{0, 1}},
            {-8, new int[]{-1, -2, -3, -4, -5}, new int[]{4, 2}}
        });
    }

    @Parameter(0)
    public int target;

    @Parameter(1)
    public int[] input;

    @Parameter(2)
    public int[] expected;

    @Test
    public void twoSumSolution1() {
        checkSolution(new Solution1());
    }

    @Test
    public void twoSumSolution2() {
        checkSolution(new Solution2());
    }

    private void checkSolution(Solution solution) {
        int[] inputData = Arrays.copyOfRange(input, 0, input.length);
        int[] expectedData = Arrays.copyOfRange(expected, 0, expected.length);
        int[] actualData = solution.twoSum(inputData, target);
        Arrays.sort(expectedData);
        Arrays.sort(actualData);
        assertArrayEquals(expectedData, actualData);
    }
}
