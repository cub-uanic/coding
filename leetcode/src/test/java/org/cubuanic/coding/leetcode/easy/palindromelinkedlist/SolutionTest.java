package org.cubuanic.coding.leetcode.easy.palindromelinkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(10);
        testData.add(new Object[][]{{new int[]{1}}, {true}});
        testData.add(new Object[][]{{new int[]{1, 2}}, {false}});
        testData.add(new Object[][]{{new int[]{1, 2, 1}}, {true}});
        testData.add(new Object[][]{{new int[]{1, 2, 2, 1}}, {true}});
        return testData;
    }

    @Parameter(0)
    public Object[] input;

    @Parameter(1)
    public Object[] expected;

    @Test
    public void isPalindrome() {
        int[] inputData = (int[]) input[0];
        boolean expectedData = (boolean) expected[0];

        ListNode head = buildList(inputData);
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(head);

        assertEquals(expectedData, result);
    }

    private ListNode buildList(int[] list) {
        ListNode head = null;
        for (int i = list.length - 1; i >= 0; i--) {
            head = new ListNode(list[i], head);
        }
        return head;
    }
}
