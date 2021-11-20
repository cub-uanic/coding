package org.cubuanic.coding.leetcode.medium.uniquepaths;

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
        testData.add(new int[][]{{1, 1}, {1}});
        testData.add(new int[][]{{2, 2}, {2}});
        testData.add(new int[][]{{3, 7}, {28}});
        testData.add(new int[][]{{3, 2}, {3}});
        testData.add(new int[][]{{3, 3}, {6}});
        testData.add(new int[][]{{23, 12}, {193536720}});
        return testData;
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void uniquePaths_direct() {
        Solution solution = new org.cubuanic.coding.leetcode.medium.uniquepaths.Solution();
        int inputM = input[0];
        int inputN = input[1];
        assertEquals(expected[0], solution.uniquePaths(inputM, inputN));
    }

    @Test
    public void uniquePaths_reversed() {
        Solution solution = new org.cubuanic.coding.leetcode.medium.uniquepaths.Solution();
        int inputM = input[0];
        int inputN = input[1];
        assertEquals(expected[0], solution.uniquePaths(inputN, inputM));
    }
}
