package org.cubuanic.coding.leetcode.easy.linkedlistcycle;

import org.cubuanic.coding.leetcode.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.cubuanic.coding.leetcode.TestUtils.buildCycledNodeList;
import static org.cubuanic.coding.leetcode.TestUtils.destroyNodeList;
import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {-1, new int[]{}, false},
            {-1, new int[]{1}, false},
            {-1, new int[]{1, 2}, false},
            {-1, new int[]{-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5}, false},
            {0, new int[]{1}, true},
            {0, new int[]{1, 2}, true},
            {1, new int[]{3, 2, 0, -4}, true}
        });
    }

    @Parameter(0)
    public int pos;

    @Parameter(1)
    public int[] input;

    @Parameter(2)
    public boolean expected;

    @Test
    public void hasCycleSolution1() {
        checkSolution(new Solution1());
    }

    @Test
    public void hasCycleSolution2() {
        checkSolution(new Solution2());
    }

    private void checkSolution(Solution solution) {
        ListNode head = buildCycledNodeList(input, pos);
        assertEquals(expected, solution.hasCycle(head));
        destroyNodeList(head);
    }
}
