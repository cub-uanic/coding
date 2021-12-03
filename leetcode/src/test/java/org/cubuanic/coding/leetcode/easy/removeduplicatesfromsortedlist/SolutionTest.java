package org.cubuanic.coding.leetcode.easy.removeduplicatesfromsortedlist;

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
        return Arrays.asList(new Object[][]{
            {new int[]{}, new int[]{}},
            {new int[]{1, 1, 2}, new int[]{1, 2}},
            {new int[]{1, 1, 2, 3, 3}, new int[]{1, 2, 3}},
        });
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void deleteDuplicates() {
        ListNode inputList = buildList(input);
        Solution solution = new Solution();
        ListNode resultList = solution.deleteDuplicates(inputList);
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
