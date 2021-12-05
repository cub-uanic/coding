package org.cubuanic.coding.leetcode.easy.containsduplicate;

import java.util.HashSet;
import java.util.Set;

class Solution2 implements Solution{
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> items = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!items.add(num)) return true;
        }
        return false;
    }
}
