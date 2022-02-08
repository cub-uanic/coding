package org.cubuanic.coding.leetcode.easy.removeduplicatesfromsortedlist;

import org.cubuanic.coding.leetcode.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.cubuanic.coding.leetcode.TestUtils.buildSimpleNodeList;
import static org.cubuanic.coding.leetcode.TestUtils.nodeListToArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{}, new int[]{}),
            Arguments.of(new int[]{1, 1, 2}, new int[]{1, 2}),
            Arguments.of(new int[]{1, 1, 2, 3, 3}, new int[]{1, 2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void deleteDuplicates(int[] input, int[] expected) {
        Solution solution = new Solution();
        ListNode inputList = buildSimpleNodeList(input);
        ListNode resultList = solution.deleteDuplicates(inputList);
        int[] result = nodeListToArray(resultList);
        assertArrayEquals(expected, result);
    }
}
