package org.cubuanic.coding.leetcode.easy.middleofthelinkedlist;

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
            {new int[]{1}, new int[]{1}},
            {new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5}},
            {new int[]{1, 2, 3, 4, 5, 6}, new int[]{4, 5, 6}}
        });
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void middleNode() {
        Solution solution = new Solution();
        ListNode head = TestUtils.buildSimpleNodeList(input);
        ListNode result = solution.middleNode(head);
        int[] resultData = nodeListToArray(result);
        assertArrayEquals(expected, resultData);
    }
}
