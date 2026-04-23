package cub.leetcode.easy.mergetwosortedlists_21;

import cub.leetcode.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static cub.leetcode.TestUtils.intListToNodeList;
import static cub.leetcode.TestUtils.nodeListToArray;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 4), List.of(1, 3, 4), List.of(1, 1, 2, 3, 4, 4)),
            Arguments.of(List.of(), List.of(), List.of()),
            Arguments.of(List.of(), List.of(0), List.of(0))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void mergeTwoLists(List<Integer> list1, List<Integer> list2, List<Integer> expected) {
        ListNode nodeList1 = intListToNodeList(list1);
        ListNode nodeList2 = intListToNodeList(list2);

        Solution solution = new Solution();
        ListNode nodeListActual = solution.mergeTwoLists(nodeList1, nodeList2);
        ListNode nodeListExpected = intListToNodeList(expected);

        int[] resultActual = nodeListToArray(nodeListActual);
        int[] resultExpected = nodeListToArray(nodeListExpected);
        assertArrayEquals(resultExpected, resultActual);
    }
}
