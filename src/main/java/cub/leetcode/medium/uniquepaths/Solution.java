package cub.leetcode.medium.uniquepaths;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        return solve(m, n, cache);
    }

    private int solve(int m, int n, int[][] cache) {
        if (m == 1 || n == 1) return 1;
        if (cache[m - 1][n - 1] != 0) return cache[m - 1][n - 1];
        return cache[m - 1][n - 1] = solve(m - 1, n, cache) + solve(m, n - 1, cache);
    }
}
