package cub.leetcode.easy.palindromelinkedlist;

import cub.leetcode.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static cub.leetcode.TestUtils.buildSimpleNodeList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{1}, true),
            Arguments.of(new int[]{1, 2}, false),
            Arguments.of(new int[]{1, 2, 1}, true),
            Arguments.of(new int[]{1, 2, 2, 1}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void isPalindrome(int[] input, boolean expected) {
        Solution solution = new Solution();
        ListNode head = buildSimpleNodeList(input);
        boolean result = solution.isPalindrome(head);
        assertEquals(expected, result);
    }
}
