package org.cubuanic.coding.leetcode.easy.singlenumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(4);
        testData.add(new int[][]{{2, 2, 1}, {1}});
        testData.add(new int[][]{{4, 1, 2, 1, 2}, {4}});
        testData.add(new int[][]{{1}, {1}});
        return testData;
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void findDisappearedNumbers() {
        Solution solution = new Solution();
        int expectedResult = expected[0];
        assertEquals(expectedResult, solution.singleNumber(input));
    }

    @Test
    public void findDisappearedNumbers2() {
        Solution2 solution = new Solution2();
        int expectedResult = expected[0];
        assertEquals(expectedResult, solution.singleNumber(input));
    }
}
