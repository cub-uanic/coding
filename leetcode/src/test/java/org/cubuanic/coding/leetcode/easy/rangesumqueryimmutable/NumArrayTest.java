package org.cubuanic.coding.leetcode.easy.rangesumqueryimmutable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class NumArrayTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {
                new int[]{-2, 0, 3, -5, 2, -1},
                new int[][]{{0, 2}, {2, 5}, {0, 5}},
                new int[]{1, -1, -3}
            }
        });
    }

    @Parameter(0)
    public int[] nums;

    @Parameter(1)
    public int[][] ranges;

    @Parameter(2)
    public int[] expected;

    @Test
    public void sumRangeSolution1() {
        checkSolution(new NumArray1(nums));
    }

    @Test
    public void sumRangeSolution2() {
        checkSolution(new NumArray2(nums));
    }

    @Test
    public void sumRangeSolution3() {
        checkSolution(new NumArray3(nums));
    }

    private void checkSolution(NumArray solution) {
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int expectedResult = expected[i];
            assertEquals(expectedResult, solution.sumRange(range[0], range[1]));
        }
    }
}
