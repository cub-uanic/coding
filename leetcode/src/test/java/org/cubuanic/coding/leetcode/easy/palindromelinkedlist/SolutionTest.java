package org.cubuanic.coding.leetcode.easy.palindromelinkedlist;

import org.cubuanic.coding.leetcode.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.cubuanic.coding.leetcode.TestUtils.buildSimpleNodeList;
import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new int[]{1}, true},
            {new int[]{1, 2}, false},
            {new int[]{1, 2, 1}, true},
            {new int[]{1, 2, 2, 1}, true}
        });
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public boolean expected;

    @Test
    public void isPalindrome() {
        Solution solution = new Solution();
        ListNode head = buildSimpleNodeList(input);
        boolean result = solution.isPalindrome(head);
        assertEquals(expected, result);
    }
}
