package org.cubuanic.coding.leetcode.medium.iteratorforcombination;

public class CombinationIterator {
    private final char[] input;
    private final char[] result;
    private final int n;
    private int mask;

    public CombinationIterator(String characters, int combinationLength) {
        this.input = characters.toCharArray();
        this.n = combinationLength;
        this.mask = ((1<<n)-1)<<(input.length-n);
        result = new char[combinationLength];
    }

    public String next() {
        int idx = 0;
        for (int i = input.length-1; i >= 0; i--) {
            if ((mask & (1 << i)) != 0) {
                result[idx++] = input[input.length - 1 - i];
            }
        }
        updateMask();
        return new String(result);
    }

    public boolean hasNext() {
        return mask != 0;
    }

    // Gospel's hack
    private void updateMask() {
        int t = mask + 1;
        int u = t ^ mask;
        int v = t & mask;
        mask = v - (v & -v) / (u + 1);
    }
}
