package org.cubuanic.coding.leetcode.medium.uniquepaths;

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
            {1, 1, 1},
            {2, 2, 2},
            {3, 7, 28},
            {3, 2, 3},
            {3, 3, 6},
            {23, 12, 193536720}
        });
    }

    @Parameter(0)
    public int inputN;

    @Parameter(1)
    public int inputM;

    @Parameter(2)
    public int expected;

    @Test
    public void uniquePaths_direct() {
        Solution solution = new Solution();
        assertEquals(expected, solution.uniquePaths(inputM, inputN));
    }

    @Test
    public void uniquePaths_reversed() {
        Solution solution = new Solution();
        assertEquals(expected, solution.uniquePaths(inputN, inputM));
    }
}
