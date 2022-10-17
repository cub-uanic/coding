package cub.leetcode.easy.findallnumbersdisappearedinanarray;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

class Solution2 implements Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = abs(nums[i]) - 1;
            nums[idx] = -abs(nums[idx]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i + 1);
        }

        return result;
    }
}
