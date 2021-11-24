package org.cubuanic.coding.leetcode.easy.climbingstairs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(10);
        testData.add(new int[][]{{1}, {1}});
        testData.add(new int[][]{{2}, {2}});
        testData.add(new int[][]{{3}, {3}});
        testData.add(new int[][]{{4}, {5}});
        return testData;
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void climbStairs() {
        Solution solution = new Solution();
        int inputN = input[0];
        assertEquals(expected[0], solution.climbStairs(inputN));
    }
}
