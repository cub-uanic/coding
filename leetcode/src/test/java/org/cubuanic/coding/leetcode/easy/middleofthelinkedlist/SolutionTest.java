package org.cubuanic.coding.leetcode.easy.middleofthelinkedlist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(10);
        testData.add(new Object[][]{{new int[]{1}}, {new int[]{1}}});
        testData.add(new Object[][]{{new int[]{1, 2, 3, 4, 5}}, {new int[]{3, 4, 5}}});
        testData.add(new Object[][]{{new int[]{1, 2, 3, 4, 5, 6}}, {new int[]{4, 5, 6}}});
        return testData;
    }

    @Parameter(0)
    public Object[] input;

    @Parameter(1)
    public Object[] expected;

    @Test
    public void middleNode() {
        int[] inputData = (int[]) input[0];
        int[] expectedData = (int[]) expected[0];

        ListNode head = buildList(inputData);
        Solution solution = new Solution();
        ListNode result = solution.middleNode(head);
        int[] resultData = buildArray(result);

        assertArrayEquals(expectedData, resultData);
    }

    private ListNode buildList(int[] list) {
        ListNode head = null;
        for (int i = list.length - 1; i >= 0; i--) {
            head = new ListNode(list[i], head);
        }
        return head;
    }

    private int[] buildArray(ListNode input) {
        List<Integer> result = new ArrayList<>();
        while (input != null) {
            result.add(input.val);
            input = input.next;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
