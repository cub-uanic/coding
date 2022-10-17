package cub.leetcode.hard.firstmissingpositive;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Solution1 implements Solution {
    // naive implementation
    @Override
    public int firstMissingPositive(int[] nums) {
        Set<Integer> seen = new TreeSet<>();
        Arrays.stream(nums).forEach(seen::add);
        int i = 1;
        while (seen.contains(i)) i++;
        return i;
    }
}
