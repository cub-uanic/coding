package org.cubuanic.coding.leetcode.easy.binarysearch;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l != r && l + 1 != r) {
            int n = (l + r) / 2;

            if (nums[n] == target) return n;
            else if (nums[n] < target) l = n;
            else r = n;
        }

        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }
}
