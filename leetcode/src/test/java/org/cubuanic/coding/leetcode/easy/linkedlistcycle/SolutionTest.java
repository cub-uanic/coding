package org.cubuanic.coding.leetcode.easy.linkedlistcycle;

import org.cubuanic.coding.leetcode.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.cubuanic.coding.leetcode.TestUtils.buildCycledNodeList;
import static org.cubuanic.coding.leetcode.TestUtils.destroyNodeList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(-1, new int[]{}, false),
            Arguments.of(-1, new int[]{1}, false),
            Arguments.of(-1, new int[]{1, 2}, false),
            Arguments.of(-1, new int[]{-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5}, false),
            Arguments.of(0, new int[]{1}, true),
            Arguments.of(0, new int[]{1, 2}, true),
            Arguments.of(1, new int[]{3, 2, 0, -4}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void hasCycleSolution1(int pos, int[] input, boolean expected) {
        checkSolution(new Solution1(), pos, input, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void hasCycleSolution2(int pos, int[] input, boolean expected) {
        checkSolution(new Solution2(), pos, input, expected);
    }

    private void checkSolution(Solution solution, int pos, int[] input, boolean expected) {
        ListNode head = buildCycledNodeList(input, pos);
        assertEquals(expected, solution.hasCycle(head));
        destroyNodeList(head);
    }
}
