package cub.leetcode.easy.destinationcity_1436;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution2 implements Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> input = paths.stream()
            .map(path -> path.get(0))
            .collect(Collectors.toSet());
        return paths.stream()
            .map(path -> path.get(1))
            .filter(output -> !input.contains(output))
            .findFirst()
            .get();
    }
}
