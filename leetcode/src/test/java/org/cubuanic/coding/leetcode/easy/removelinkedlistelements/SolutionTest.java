package org.cubuanic.coding.leetcode.easy.removelinkedlistelements;

import org.cubuanic.coding.leetcode.ListNode;
import org.cubuanic.coding.leetcode.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.cubuanic.coding.leetcode.TestUtils.nodeListToArray;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {2, new int[]{1, 2, 2, 1}, new int[]{1, 1}},
            {1, new int[]{}, new int[]{}},
            {1, new int[]{1, 2, 2, 1}, new int[]{2, 2}},
            {7, new int[]{7, 7, 7, 7}, new int[]{}},
            {6, new int[]{1, 2, 6, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5}}
        });
    }

    @Parameter(0)
    public int inputVal;

    @Parameter(1)
    public int[] inputData;

    @Parameter(2)
    public int[] expected;

    @Test
    public void removeElements() {
        Solution solution = new Solution();
        ListNode inputList = TestUtils.buildSimpleNodeList(inputData);
        ListNode resultList = solution.removeElements(inputList, inputVal);
        int[] result = nodeListToArray(resultList);
        assertArrayEquals(expected, result);
    }
}
