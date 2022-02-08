package org.cubuanic.coding.leetcode.easy.findallnumbersdisappearedinanarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.cubuanic.coding.leetcode.TestUtils.intArrayToList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, new int[]{5, 6}),
            Arguments.of(new int[]{1, 1}, new int[]{2}),
            Arguments.of(new int[]{8, 8, 8, 8, 8, 8, 8, 8}, new int[]{1, 2, 3, 4, 5, 6, 7})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void findDisappearedNumbersSolution1(int[] input, int[] expected) {
        checkSolution(new Solution1(), input, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void findDisappearedNumbersSolution2(int[] input, int[] expected) {
        checkSolution(new Solution2(), input, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    public void findDisappearedNumbersSolution3(int[] input, int[] expected) {
        checkSolution(new Solution3(), input, expected);
    }

    private void checkSolution(Solution solution, int[] input, int[] expected) {
        int[] inputCopy = Arrays.copyOf(input, input.length);
        List<Integer> actual = solution.findDisappearedNumbers(inputCopy);
        List<Integer> expectedList = intArrayToList(expected);
        assertTrue(actual.containsAll(expectedList));
    }
}
