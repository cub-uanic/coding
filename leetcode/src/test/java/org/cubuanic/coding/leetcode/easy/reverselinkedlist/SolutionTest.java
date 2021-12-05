package org.cubuanic.coding.leetcode.easy.reverselinkedlist;

import org.cubuanic.coding.leetcode.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.cubuanic.coding.leetcode.TestUtils.buildSimpleNodeList;
import static org.cubuanic.coding.leetcode.TestUtils.nodeListToArray;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new int[]{}, new int[]{}},
            {new int[]{1, 2}, new int[]{2, 1}},
            {new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}},
        });
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void reverseList() {
        Solution solution = new Solution();
        ListNode inputList = buildSimpleNodeList(input);
        ListNode resultList = solution.reverseList(inputList);
        int[] result = nodeListToArray(resultList);
        assertArrayEquals(expected, result);
    }
}
