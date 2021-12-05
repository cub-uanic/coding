package org.cubuanic.coding.leetcode.medium.dailytemperatures;

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
            {new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}},
            {new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}},
            {new int[]{30, 60, 90}, new int[]{1, 1, 0}},
            {new int[]{13, 12, 15, 11, 9, 12, 16}, new int[]{2, 1, 4, 2, 1, 1, 0}}
        });
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void dailyTemperaturesSolution1() {
        checkSolution(new Solution1());
    }

    @Test
    public void dailyTemperaturesSolution2() {
        checkSolution(new Solution2());
    }

    private void checkSolution(Solution solution) {
        assertArrayEquals(expected, solution.dailyTemperatures(input));
    }
}
