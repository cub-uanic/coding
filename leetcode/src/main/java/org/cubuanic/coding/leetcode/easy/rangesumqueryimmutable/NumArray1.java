package org.cubuanic.coding.leetcode.easy.rangesumqueryimmutable;

class NumArray1 implements NumArray {
    private final int[] nums;

    public NumArray1(int[] nums) {
        this.nums = nums;
    }

    @Override
    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
