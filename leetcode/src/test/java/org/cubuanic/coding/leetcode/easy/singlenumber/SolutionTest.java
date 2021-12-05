package org.cubuanic.coding.leetcode.easy.singlenumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new int[]{2, 2, 1}, 1},
            {new int[]{4, 1, 2, 1, 2}, 4},
            {new int[]{1}, 1}
        });
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int expected;

    @Test
    public void findDisappearedNumbersSolution1() {
        checkSolution(new Solution1());
    }

    @Test
    public void findDisappearedNumbersSolution2() {
        checkSolution(new Solution2());
    }

    private void checkSolution(Solution solution) {
        assertEquals(expected, solution.singleNumber(input));
    }
}
