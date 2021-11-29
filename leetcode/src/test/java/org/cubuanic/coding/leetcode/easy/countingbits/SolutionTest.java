package org.cubuanic.coding.leetcode.easy.countingbits;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(10);
        testData.add(new Object[][]{{0}, {new int[]{0}}});
        testData.add(new Object[][]{{2}, {new int[]{0, 1, 1}}});
        testData.add(new Object[][]{{5}, {new int[]{0, 1, 1, 2, 1, 2}}});
        testData.add(new Object[][]{{7}, {new int[]{0, 1, 1, 2, 1, 2, 2, 3}}});
        testData.add(new Object[][]{{8}, {new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1}}});
        return testData;
    }

    @Parameter(0)
    public Object[] input;

    @Parameter(1)
    public Object[] expected;

    @Test
    public void countBits() {
        int n = (int) input[0];
        int[] expectedResult = (int[]) expected[0];

        Solution solution = new Solution();
        assertArrayEquals(expectedResult, solution.countBits(n));
    }
}
