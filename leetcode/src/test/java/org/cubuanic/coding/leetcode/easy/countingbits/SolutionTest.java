package org.cubuanic.coding.leetcode.easy.countingbits;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {0, new int[]{0}},
            {2, new int[]{0, 1, 1}},
            {5, new int[]{0, 1, 1, 2, 1, 2}},
            {7, new int[]{0, 1, 1, 2, 1, 2, 2, 3}},
            {8, new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1}}
        });
    }

    @Parameter(0)
    public int input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void countBits() {
        Solution solution = new Solution();
        assertArrayEquals(expected, solution.countBits(input));
    }
}
