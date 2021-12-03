package org.cubuanic.coding.leetcode.easy.removelinkedlistelements;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Iterable<Object[]> data() {
        final var objects = Arrays.asList(new Object[][]{
            {2, new int[]{1, 2, 2, 1}, new int[]{1, 1}},
            {1, new int[]{}, new int[]{}},
            {1, new int[]{1, 2, 2, 1}, new int[]{2, 2}},
            {7, new int[]{7, 7, 7, 7}, new int[]{}},
            {6, new int[]{1, 2, 6, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5}}
        });
        return objects;
    }

    @Parameter(0)
    public int inputVal;

    @Parameter(1)
    public int[] inputData;

    @Parameter(2)
    public int[] expected;

    @Test
    public void removeElements() {
        ListNode inputList = buildList(inputData);
        Solution solution = new Solution();
        ListNode resultList = solution.removeElements(inputList, inputVal);
        int[] result = buildArray(resultList);

        assertArrayEquals(expected, result);
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
