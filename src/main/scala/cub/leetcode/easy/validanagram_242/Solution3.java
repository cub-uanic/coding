package cub.leetcode.easy.validanagram_242;

import java.util.HashMap;
import java.util.Map;

public class Solution3 implements Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char c;
        Map<Character, Integer> data = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            data.put(c, data.getOrDefault(c, 0) + 1);
            c = t.charAt(i);
            data.put(c, data.getOrDefault(c, 0) - 1);
        }

        for (Integer value : data.values()) {
            if (value != 0) return false;
        }

        return true;
    }
}
