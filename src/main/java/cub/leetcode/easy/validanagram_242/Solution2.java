package cub.leetcode.easy.validanagram_242;

public class Solution2 implements Solution {
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if (len != t.length()) return false;

        int[] data = new int[26];
        for (int i = 0; i < len; i++) {
            data[s.charAt(i) - 'a']++;
            data[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (data[i] != 0) return false;
        }

        return true;
    }
}
