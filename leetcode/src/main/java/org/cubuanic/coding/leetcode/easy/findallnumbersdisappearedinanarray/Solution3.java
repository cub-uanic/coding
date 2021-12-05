package org.cubuanic.coding.leetcode.easy.findallnumbersdisappearedinanarray;

import java.util.ArrayList;
import java.util.List;

class Solution3 implements Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] found = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            found[nums[i] - 1] = true;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!found[i]) result.add(i + 1);
        }

        return result;
    }
}
