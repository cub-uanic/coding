package cub.leetcode.easy.singlenumber;

class Solution1 implements Solution {
    @Override
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }
}
