package cub.leetcode.easy.maximumsubarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSubArraySum = nums[0];
        int currSubArraySum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currSubArraySum + nums[i]) currSubArraySum = nums[i];
            else currSubArraySum += nums[i];
            if (currSubArraySum > maxSubArraySum) maxSubArraySum = currSubArraySum;
        }

        return maxSubArraySum;
    }
}
