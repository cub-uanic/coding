package org.cubuanic.coding.leetcode.easy.twosum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(4);
        testData.add(new int[][]{{-1, 0, 3, -3, 4, -1}, {4, 0}});
        testData.add(new int[][]{{10, 2, 5, 5, 11}, {1, 2}});
        testData.add(new int[][]{{9, 2, 7, 11, 15}, {0, 1}});
        testData.add(new int[][]{{6, 3, 2, 4}, {1, 2}});
        testData.add(new int[][]{{6, 3, 3}, {0, 1}});
        testData.add(new int[][]{{-8, -1, -2, -3, -4, -5}, {4, 2}});
        return testData;
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void arrangeCoins() {
        Solution solution = new Solution();
        int inputTarget = input[0];
        int[] inputData = Arrays.copyOfRange(input, 1, input.length);
        assertArrayEquals(expected, solution.twoSum(inputData, inputTarget));
    }

    @Test
    public void arrangeCoins2() {
        Solution2 solution = new Solution2();
        int inputTarget = input[0];
        int[] inputData = Arrays.copyOfRange(input, 1, input.length);
        int[] actual = solution.twoSum(inputData, inputTarget);
        Arrays.sort(expected);
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}
