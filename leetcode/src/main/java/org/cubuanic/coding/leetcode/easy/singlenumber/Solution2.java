package org.cubuanic.coding.leetcode.easy.singlenumber;

import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public int singleNumber(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                seen.remove(num);
            }
        }

        return seen.stream().findFirst().get();
    }
}
