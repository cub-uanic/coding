package org.cubuanic.coding.leetcode.easy.maximumsubarray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new int[]{1}, 1},
            {new int[]{-1}, -1},
            {new int[]{1, 2}, 3},
            {new int[]{2, 1}, 3},
            {new int[]{-1, -2}, -1},
            {new int[]{-2, -1}, -1},
            {new int[]{-1, 1, 2}, 3},
            {new int[]{-1, 2, 1}, 3},
            {new int[]{1, 2, -1}, 3},
            {new int[]{2, 1, -1}, 3},
            {new int[]{-1, 2}, 2},
            {new int[]{2, -1}, 2},
            {new int[]{5, 4, -1, 7, 8}, 23},
            {new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6},
            {new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 400}, 401}
        });
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int expected;

    @Test
    public void maxSubArray() {
        Solution solution = new Solution();
        assertEquals(expected, solution.maxSubArray(input));
    }
}
