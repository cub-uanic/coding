package org.cubuanic.coding.leetcode.easy.binarysearch;

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
            {9, new int[]{-1, 0, 3, 5, 9, 12}, 4},
            {2, new int[]{-1, 0, 3, 5, 9, 12}, -1},
            {5, new int[]{5}, 0},
            {5, new int[]{2, 5}, 1},
            {2, new int[]{2, 5}, 0},
            {5, new int[]{2, 3, 5}, 2}
        });
    }

    @Parameter(0)
    public int inputTarget;

    @Parameter(1)
    public int[] inputData;

    @Parameter(2)
    public int expected;

    @Test
    public void binarySearchTest() {
        Solution solution = new Solution();
        assertEquals(expected, solution.search(inputData, inputTarget));
    }
}
