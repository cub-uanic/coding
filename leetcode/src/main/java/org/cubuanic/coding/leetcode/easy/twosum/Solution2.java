package org.cubuanic.coding.leetcode.easy.twosum;

import java.util.HashMap;

class Solution2 implements Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> lookup = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (lookup.containsKey(nums[i])) {
                return new int[]{i, lookup.get(nums[i])};
            }
            lookup.put(target - nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
