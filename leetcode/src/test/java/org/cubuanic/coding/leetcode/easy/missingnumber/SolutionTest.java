package org.cubuanic.coding.leetcode.easy.missingnumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new int[]{3, 0, 1}, 2},
            {new int[]{0, 1}, 2},
            {new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8},
            {new int[]{0}, 1}
        });
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int expected;

    @Test
    public void missingNumber() {
        Solution solution = new Solution();
        assertEquals(expected, solution.missingNumber(input));
    }
}
