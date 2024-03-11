package cub.leetcode.easy.intersectionoftwoarrays_349;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1set = Arrays.stream(nums1)
            .boxed()
            .collect(Collectors.toCollection(TreeSet::new));
        Set<Integer> nums2set = Arrays.stream(nums2)
            .boxed()
            .collect(Collectors.toCollection(TreeSet::new));

        nums1set.retainAll(nums2set);

        return nums1set.stream().mapToInt(Number::intValue).toArray();
    }
}
