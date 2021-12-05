package org.cubuanic.coding.leetcode.easy.findallnumbersdisappearedinanarray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.List;

import static org.cubuanic.coding.leetcode.TestUtils.intArrayToList;
import static org.junit.Assert.assertTrue;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {new int[]{4, 3, 2, 7, 8, 2, 3, 1}, new int[]{5, 6}},
            {new int[]{1, 1}, new int[]{2}},
            {new int[]{8, 8, 8, 8, 8, 8, 8, 8}, new int[]{1, 2, 3, 4, 5, 6, 7}}
        });
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void findDisappearedNumbersSolution1() {
        checkSolution(new Solution1());
    }

    @Test
    public void findDisappearedNumbersSolution2() {
        checkSolution(new Solution2());
    }

    @Test
    public void findDisappearedNumbersSolution3() {
        checkSolution(new Solution3());
    }

    private void checkSolution(Solution solution) {
        int[] inputCopy = Arrays.copyOf(input, input.length);
        List<Integer> actual = solution.findDisappearedNumbers(inputCopy);
        List<Integer> expectedList = intArrayToList(expected);
        assertTrue(actual.containsAll(expectedList));
    }
}
