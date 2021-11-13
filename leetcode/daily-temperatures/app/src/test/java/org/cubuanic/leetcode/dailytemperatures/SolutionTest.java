package org.cubuanic.leetcode.dailytemperatures;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(4);
        testData.add(new int[][]{{73, 74, 75, 71, 69, 72, 76, 73}, {1, 1, 4, 2, 1, 1, 0, 0}});
        testData.add(new int[][]{{30, 40, 50, 60}, {1, 1, 1, 0}});
        testData.add(new int[][]{{30, 60, 90}, {1, 1, 0}});
        testData.add(new int[][]{{13, 12, 15, 11, 9, 12, 16}, {2, 1, 4, 2, 1, 1, 0}});
        return testData;
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void dailyTemperaturesSolution1() {
        Solution solution = new Solution();
        assertArrayEquals(expected, solution.dailyTemperatures(input));
    }

    @Test
    public void dailyTemperaturesSolution2() {
        Solution2 solution = new Solution2();
        assertArrayEquals(expected, solution.dailyTemperatures(input));
    }
}
