package org.cubuanic.coding.leetcode.easy.climbingstairs;

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
            {1, 1},
            {2, 2},
            {3, 3},
            {4, 5}
        });
    }

    @Parameter(0)
    public int input;

    @Parameter(1)
    public int expected;

    @Test
    public void climbStairs() {
        Solution solution = new Solution();
        assertEquals(expected, solution.climbStairs(input));
    }
}
