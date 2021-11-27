package org.cubuanic.coding.leetcode.easy.maximumsubarray;

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
        testData.add(new int[][]{{-1}, {-1}});
        testData.add(new int[][]{{1, 2}, {3}});
        testData.add(new int[][]{{2, 1}, {3}});
        testData.add(new int[][]{{-1, -2}, {-1}});
        testData.add(new int[][]{{-2, -1}, {-1}});
        testData.add(new int[][]{{-1, 1, 2}, {3}});
        testData.add(new int[][]{{-1, 2, 1}, {3}});
        testData.add(new int[][]{{1, 2, -1}, {3}});
        testData.add(new int[][]{{2, 1, -1}, {3}});
        testData.add(new int[][]{{-1, 2}, {2}});
        testData.add(new int[][]{{2, -1}, {2}});
        testData.add(new int[][]{{5, 4, -1, 7, 8}, {23}});
        testData.add(new int[][]{{-2, 1, -3, 4, -1, 2, 1, -5, 4}, {6}});
        testData.add(new int[][]{{-2, 1, -3, 4, -1, 2, 1, -5, 400}, {401}});
        return testData;
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void maxSubArray() {
        Solution solution = new Solution();
        assertEquals(expected[0], solution.maxSubArray(input));
    }
}
