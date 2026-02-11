package cub.leetcode.easy.destinationcity_1436;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 implements Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> graph = new HashMap<>(paths.size());
        for (List<String> path : paths) {
            graph.put(path.get(0), path.get(1));
        }

        String prev = null;
        String city = paths.get(0).get(0);
        while (city != null) {
            prev = city;
            city = graph.get(city);
        }

        return prev;
    }
}
