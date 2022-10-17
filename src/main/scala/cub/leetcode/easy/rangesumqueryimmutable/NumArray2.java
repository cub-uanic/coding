package cub.leetcode.easy.rangesumqueryimmutable;

class NumArray2 implements NumArray {
    private final int[] sums;

    public NumArray2(int[] nums) {
        this.sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) return sums[right];
        else return sums[right] - sums[left - 1];
    }
}
