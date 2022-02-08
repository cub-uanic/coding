package org.cubuanic.coding.leetcode.easy.middleofthelinkedlist;

import org.cubuanic.coding.leetcode.ListNode;
import org.cubuanic.coding.leetcode.TestUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.cubuanic.coding.leetcode.TestUtils.nodeListToArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{1}, new int[]{1}),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5}),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{4, 5, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void middleNode(int[] input, int[] expected) {
        Solution solution = new Solution();
        ListNode head = TestUtils.buildSimpleNodeList(input);
        ListNode result = solution.middleNode(head);
        int[] resultData = nodeListToArray(result);
        assertArrayEquals(expected, resultData);
    }
}
