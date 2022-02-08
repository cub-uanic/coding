package org.cubuanic.coding.leetcode.easy.removelinkedlistelements;

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
            Arguments.of(2, new int[]{1, 2, 2, 1}, new int[]{1, 1}),
            Arguments.of(1, new int[]{}, new int[]{}),
            Arguments.of(1, new int[]{1, 2, 2, 1}, new int[]{2, 2}),
            Arguments.of(7, new int[]{7, 7, 7, 7}, new int[]{}),
            Arguments.of(6, new int[]{1, 2, 6, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void removeElements(int inputVal, int[] inputData, int[] expected) {
        Solution solution = new Solution();
        ListNode inputList = TestUtils.buildSimpleNodeList(inputData);
        ListNode resultList = solution.removeElements(inputList, inputVal);
        int[] result = nodeListToArray(resultList);
        assertArrayEquals(expected, result);
    }
}
