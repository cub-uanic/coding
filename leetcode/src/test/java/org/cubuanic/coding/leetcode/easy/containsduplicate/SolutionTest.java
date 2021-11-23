package org.cubuanic.coding.leetcode.easy.containsduplicate;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(4);
        testData.add(new int[][]{{1, 2, 3, 1}, {1}});
        testData.add(new int[][]{{1, 2, 3, 4}, {0}});
        testData.add(new int[][]{{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, {1}});
        return testData;
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void containsDuplicate() {
        Solution solution = new Solution();
        boolean expectedResult = expected[0] == 1;
        assertEquals(expectedResult, solution.containsDuplicate(input));
    }

    @Test
    public void containsDuplicate2() {
        Solution2 solution = new Solution2();
        boolean expectedResult = expected[0] == 1;
        assertEquals(expectedResult, solution.containsDuplicate(input));
    }
}
