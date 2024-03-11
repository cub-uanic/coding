package cub.leetcode.easy.intersectionoftwoarrays_349;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static cub.leetcode.TestUtils.intArrayToList;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2}),
            Arguments.of(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{4, 9})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void intersection(int[] nums1, int[] nums2, int[] expected) {
//        int[] nums1Copy = Arrays.copyOf(nums1, nums1.length);
//        int[] nums2Copy = Arrays.copyOf(nums2, nums2.length);
        Solution solution = new Solution();
        List<Integer> actualList = intArrayToList(solution.intersection(nums1, nums2));
        List<Integer> expectedList = intArrayToList(expected);
        assertTrue(actualList.containsAll(expectedList));
    }
}
