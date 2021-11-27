package org.cubuanic.coding.leetcode.easy.rangesumqueryimmutable;

class NumArray3 {
    private final int[] sums;

    public NumArray3(int[] nums) {
        this.sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
