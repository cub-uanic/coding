package org.cubuanic.leetcode.dailytemperatures;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();
        int[] output = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().getKey() <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                output[i] = stack.peek().getValue() - i;
            }
            stack.push(new AbstractMap.SimpleEntry<>(temperatures[i], i));
        }
        return output;
    }
}
