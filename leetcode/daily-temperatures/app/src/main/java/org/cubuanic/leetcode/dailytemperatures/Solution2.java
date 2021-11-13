package org.cubuanic.leetcode.dailytemperatures;

public class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int stackTop = -1;
        int[] stack = new int[temperatures.length];
        int[] output = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (stackTop >= 0 && temperatures[stack[stackTop]] <= temperatures[i]) {
                stackTop--;
            }
            if (stackTop >= 0) {
                output[i] = stack[stackTop] - i;
            }
            stackTop++;
            stack[stackTop] = i;
        }
        return output;
    }
}
