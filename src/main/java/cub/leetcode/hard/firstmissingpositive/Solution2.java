package cub.leetcode.hard.firstmissingpositive;

public class Solution2 implements Solution {
    // fast implementation
    @Override
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int x = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = x;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
