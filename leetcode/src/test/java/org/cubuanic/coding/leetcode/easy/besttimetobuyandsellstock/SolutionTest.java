package org.cubuanic.coding.leetcode.easy.besttimetobuyandsellstock;

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
            {new int[]{7, 1, 5, 3, 6, 4}, 5},
            {new int[]{7, 6, 4, 3, 1}, 0},
            {new int[]{2, 1, 4}, 3},
            {new int[]{1, 2, 4}, 3},
            {new int[]{1, 4, 2}, 3},
            {new int[]{4, 1, 2}, 1},
            {new int[]{4, 2, 1}, 0}
        });
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int expected;

    @Test
    public void maxProfit() {
        Solution solution = new Solution();
        assertEquals(expected, solution.maxProfit(input));
    }
}
