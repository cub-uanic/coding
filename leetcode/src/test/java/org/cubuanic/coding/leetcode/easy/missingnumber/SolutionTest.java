package org.cubuanic.coding.leetcode.easy.missingnumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> testData = new ArrayList<>(4);
        testData.add(new int[][]{{3, 0, 1}, {2}});
        testData.add(new int[][]{{0, 1}, {2}});
        testData.add(new int[][]{{9, 6, 4, 2, 3, 5, 7, 0, 1}, {8}});
        testData.add(new int[][]{{0}, {1}});
        return testData;
    }

    @Parameter(0)
    public int[] input;

    @Parameter(1)
    public int[] expected;

    @Test
    public void missingNumber() {
        Solution solution = new Solution();
        int expectedResult = expected[0];
        assertEquals(expectedResult, solution.missingNumber(input));
    }
}
