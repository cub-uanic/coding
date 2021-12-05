package org.cubuanic.coding.leetcode.easy.twosum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution1 implements Solution {
    @Override
    public int[] twoSum(int[] nums, int target) {
        class Item {
            public final int idx, val;

            Item(int idx, int val) {
                this.idx = idx;
                this.val = val;
            }
        }

        class ItemComparator implements Comparator<Item> {
            @Override
            public int compare(Item a, Item b) {
                return a.val - b.val;
            }
        }

        List<Item> elements = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            elements.add(new Item(i, nums[i]));
        }
        elements.sort(new ItemComparator());

        int leftIndex = 0;
        int minRightIndex = leftIndex + 1;
        int maxRightIndex = nums.length - 1;
        int rightIndex;
        int sum;

        do {
            rightIndex = (minRightIndex + maxRightIndex) / 2;
            while (true) {
                sum = elements.get(leftIndex).val + elements.get(rightIndex).val;
                if (sum == target || minRightIndex == maxRightIndex) {
                    break;
                } else if (sum < target) {
                    minRightIndex = rightIndex;
                    if (minRightIndex + 1 == maxRightIndex) {
                        minRightIndex++;
                    }
                } else { // sum > target
                    maxRightIndex = rightIndex;
                }

                rightIndex = (minRightIndex + maxRightIndex) / 2;
            }

            if (sum != target) {
                leftIndex++;
                sum = elements.get(leftIndex).val + elements.get(rightIndex).val;
                if (sum < target) {
                    maxRightIndex = nums.length - 1;
                } else if (sum > target) {
                    minRightIndex = leftIndex + 1;
                } else {
                    // do nothing, will exit loop due to sum == target
                }

            }
        } while (sum != target);

        return new int[]{elements.get(leftIndex).idx, elements.get(rightIndex).idx};
    }
}
