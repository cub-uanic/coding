package org.cubuanic.leetcode.arrangingcoins;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {5, 2},
            {8, 3},
            {1804289383, 60070}
        });
    }

    @Parameter(0)
    public int input;

    @Parameter(1)
    public int expected;

    @Test
    public void arrangeCoins() {
        Solution solution = new Solution();
        assertEquals(expected, solution.arrangeCoins(input));
    }
}
