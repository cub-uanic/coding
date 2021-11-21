package org.cubuanic.coding.leetcode.easy.binarysearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(4);
        testData.add(new int[][]{{9, -1, 0, 3, 5, 9, 12}, {4}});
        testData.add(new int[][]{{2, -1, 0, 3, 5, 9, 12}, {-1}});
        testData.add(new int[][]{{5, 5}, {0}});
        testData.add(new int[][]{{5, 2, 5}, {1}});
        testData.add(new int[][]{{2, 2, 5}, {0}});
        testData.add(new int[][]{{5, 2, 3, 5}, {2}});
        return testData;
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void binarySearchTest() {
        Solution solution = new Solution();
        int inputTarget = input[0];
        int[] inputData = Arrays.copyOfRange(input, 1, input.length);
        int expectedOutput = expected[0];
        assertEquals(expectedOutput, solution.search(inputData, inputTarget));
    }
}
