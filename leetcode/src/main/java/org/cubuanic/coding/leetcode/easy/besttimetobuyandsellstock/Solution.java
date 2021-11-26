package org.cubuanic.coding.leetcode.easy.besttimetobuyandsellstock;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for (int currPrice : prices) {
            if (currPrice < minPrice) minPrice = currPrice;
            else if (currPrice - minPrice > maxProfit) maxProfit = currPrice - minPrice;
        }
        return maxProfit;
    }
}
