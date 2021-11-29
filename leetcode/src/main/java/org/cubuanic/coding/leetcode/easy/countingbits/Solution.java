package org.cubuanic.coding.leetcode.easy.countingbits;

class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int m = 1;
        while (m < n + 1) {
            for (int i = 0; i < m; i++) {
                if (m + i >= n + 1) break;
                result[m + i] = result[i] + 1;
            }
            m <<= 1;
        }
        return result;
    }
}
