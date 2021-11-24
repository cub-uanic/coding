package org.cubuanic.coding.leetcode.easy.findallnumbersdisappearedinanarray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(4);
        testData.add(new int[][]{{4, 3, 2, 7, 8, 2, 3, 1}, {5, 6}});
        testData.add(new int[][]{{1, 1}, {2}});
        testData.add(new int[][]{{8, 8, 8, 8, 8, 8, 8, 8}, {1, 2, 3, 4, 5, 6, 7}});
        return testData;
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void findDisappearedNumbers() {
        Solution solution = new Solution();
        int[] inputCopy = Arrays.copyOf(input, input.length);
        List<Integer> actual = solution.findDisappearedNumbers(inputCopy);
        List<Integer> expectedList = Arrays.stream(expected).boxed().collect(Collectors.toUnmodifiableList());
        assertTrue(actual.containsAll(expectedList));
    }

    @Test
    public void findDisappearedNumbers2() {
        Solution2 solution = new Solution2();
        int[] inputCopy = Arrays.copyOf(input, input.length);
        List<Integer> actual = solution.findDisappearedNumbers(inputCopy);
        List<Integer> expectedList = Arrays.stream(expected).boxed().collect(Collectors.toUnmodifiableList());
        assertTrue(actual.containsAll(expectedList));
    }

    @Test
    public void findDisappearedNumbers3() {
        Solution3 solution = new Solution3();
        int[] inputCopy = Arrays.copyOf(input, input.length);
        List<Integer> actual = solution.findDisappearedNumbers(inputCopy);
        List<Integer> expectedList = Arrays.stream(expected).boxed().collect(Collectors.toUnmodifiableList());
        assertTrue(actual.containsAll(expectedList));
    }
}
