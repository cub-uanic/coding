package cub.leetcode.easy.destinationcity_1436;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 implements Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> in = new HashSet<>();
        Set<String> out = new HashSet<>();
        paths.forEach(path -> {
            in.add(path.get(0));
            out.add(path.get(1));
        });
        out.removeAll(in);
        return out.iterator().next();
    }
}
