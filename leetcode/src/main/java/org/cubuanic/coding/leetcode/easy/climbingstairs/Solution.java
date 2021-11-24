package org.cubuanic.coding.leetcode.easy.climbingstairs;

class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n];
        return solve(n, cache);
    }

    private int solve(int n, int[] cache) {
        if (n <= 1) return 1;
        if (cache[n - 1] != 0) return cache[n - 1];
        return cache[n - 1] = solve(n - 1, cache) + solve(n - 2, cache);
    }
}
