package cub.leetcode.easy.removeduplicatesfromsortedlist;

import cub.leetcode.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static cub.leetcode.TestUtils.buildSimpleNodeList;
import static cub.leetcode.TestUtils.nodeListToArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{}, new int[]{}),
            Arguments.of(new int[]{1, 1, 2}, new int[]{1, 2}),
            Arguments.of(new int[]{1, 1, 2, 3, 3}, new int[]{1, 2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void deleteDuplicates(int[] input, int[] expected) {
        Solution solution = new Solution();
        ListNode inputList = buildSimpleNodeList(input);
        ListNode resultList = solution.deleteDuplicates(inputList);
        int[] result = nodeListToArray(resultList);
        assertArrayEquals(expected, result);
    }
}
