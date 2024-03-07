package cub.leetcode.easy.validanagram_242;

public class Solution1 implements Solution {
    @Override
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char c;
        int[] sdata = new int[26];
        int[] tdata = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            sdata[c - 'a']++;
            c = t.charAt(i);
            tdata[c - 'a']++;
        }

        for (int i = 0; i < sdata.length; i++) {
            if (sdata[i] != tdata[i]) return false;
        }

        return true;
    }
}
