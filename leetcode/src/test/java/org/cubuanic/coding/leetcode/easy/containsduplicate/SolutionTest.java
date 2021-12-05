package org.cubuanic.coding.leetcode.easy.containsduplicate;


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
            {new int[]{1, 2, 3, 1}, true},
            {new int[]{1, 2, 3, 4}, false},
            {new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true}
        });
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public boolean expected;

    @Test
    public void containsDuplicateSolution1() {
        checkSolution(new Solution1());
    }

    @Test
    public void containsDuplicateSolution2() {
        checkSolution(new Solution2());
    }

    private void checkSolution(Solution solution) {
        assertEquals(expected, solution.containsDuplicate(input));
    }
}
