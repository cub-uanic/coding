package org.cubuanic.coding.leetcode.easy.rangesumqueryimmutable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class NumArrayTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(10);
        testData.add(new Object[][]{
            {new int[]{-2, 0, 3, -5, 2, -1}, new int[]{0, 2}, new int[]{2, 5}, new int[]{0, 5}},
            {1, -1, -3}
        });
        return testData;
    }

    @Parameter(0)
    public Object[] input;

    @Parameter(1)
    public Object[] expected;

    @Test
    public void sumRange() {
        int[] nums = (int[]) input[0];
        NumArray solution = new NumArray(nums);
        Object[] ranges = Arrays.copyOfRange(input, 1, input.length);

        for (int i = 0; i < ranges.length; i++) {
            int[] range = (int[]) ranges[i];
            int expectedResult = (int) expected[i];
            assertEquals(expectedResult, solution.sumRange(range[0], range[1]));
        }
    }

    @Test
    public void sumRange2() {
        int[] nums = (int[]) input[0];
        NumArray2 solution = new NumArray2(nums);
        Object[] ranges = Arrays.copyOfRange(input, 1, input.length);

        for (int i = 0; i < ranges.length; i++) {
            int[] range = (int[]) ranges[i];
            int expectedResult = (int) expected[i];
            assertEquals(expectedResult, solution.sumRange(range[0], range[1]));
        }
    }

    @Test
    public void sumRange3() {
        int[] nums = (int[]) input[0];
        NumArray3 solution = new NumArray3(nums);
        Object[] ranges = Arrays.copyOfRange(input, 1, input.length);

        for (int i = 0; i < ranges.length; i++) {
            int[] range = (int[]) ranges[i];
            int expectedResult = (int) expected[i];
            assertEquals(expectedResult, solution.sumRange(range[0], range[1]));
        }
    }
}
