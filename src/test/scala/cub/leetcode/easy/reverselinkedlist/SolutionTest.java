package cub.leetcode.easy.reverselinkedlist;

import cub.leetcode.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static cub.leetcode.TestUtils.buildSimpleNodeList;
import static cub.leetcode.TestUtils.nodeListToArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{}, new int[]{}),
            Arguments.of(new int[]{1, 2}, new int[]{2, 1}),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void reverseList(int[] input, int[] expected) {
        Solution solution = new Solution();
        ListNode inputList = buildSimpleNodeList(input);
        ListNode resultList = solution.reverseList(inputList);
        int[] result = nodeListToArray(resultList);
        assertArrayEquals(expected, result);
    }
}
