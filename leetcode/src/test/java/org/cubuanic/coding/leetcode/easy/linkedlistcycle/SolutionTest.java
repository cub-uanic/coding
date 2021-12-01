package org.cubuanic.coding.leetcode.easy.linkedlistcycle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(10);
        testData.add(new Object[][]{{-1, new int[]{}}, {false}});
        testData.add(new Object[][]{{-1, new int[]{1}}, {false}});
        testData.add(new Object[][]{{-1, new int[]{1, 2}}, {false}});
        testData.add(new Object[][]{{-1, new int[]{-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5}}, {false}});
        testData.add(new Object[][]{{0, new int[]{1}}, {true}});
        testData.add(new Object[][]{{0, new int[]{1, 2}}, {true}});
        testData.add(new Object[][]{{1, new int[]{3, 2, 0, -4}}, {true}});
        return testData;
    }

    @Parameter(0)
    public Object[] input;

    @Parameter(1)
    public Object[] expected;

    @Test
    public void hasCycle() {
        int pos = (int) input[0];
        int[] list = (int[]) input[1];
        boolean expectedResult = (boolean) expected[0];

        ListNode head = buildList(list, pos);

        Solution solution = new Solution();
        assertEquals(expectedResult, solution.hasCycle(head));

        destroyList(head);
    }

    @Test
    public void hasCycle2() {
        int pos = (int) input[0];
        int[] list = (int[]) input[1];
        boolean expectedResult = (boolean) expected[0];

        ListNode head = buildList(list, pos);

        Solution2 solution = new Solution2();
        assertEquals(expectedResult, solution.hasCycle(head));

        destroyList(head);
    }

    private ListNode buildList(int[] list, int pos) {
        if (list.length == 0) return null;

        ListNode head = null, tail = null, loop = null, curr = null, prev;
        for (int i = list.length - 1; i >= 0; i--) {
            prev = curr;
            curr = new ListNode(list[i]);
            if (i == 0) head = curr;
            if (i == pos) loop = curr;
            if (i == list.length - 1) tail = curr;
            curr.next = prev;
        }

        if (pos != -1) tail.next = loop;

        return head;
    }

    private void destroyList(@Nullable ListNode head) {
        while (head != null && head.next != null) {
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }
    }
}
