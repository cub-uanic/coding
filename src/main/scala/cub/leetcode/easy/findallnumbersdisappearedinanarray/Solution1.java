package cub.leetcode.easy.findallnumbersdisappearedinanarray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution1 implements Solution {
    @Override
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> items = new HashSet<>(nums.length);
        for (int i = 1; i <= nums.length; i++) {
            items.add(i);
        }
        for (int num : nums) {
            items.remove(num);
        }

        return new ArrayList<>(items);
    }
}
