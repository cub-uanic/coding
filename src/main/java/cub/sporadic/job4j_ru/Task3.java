package cub.sporadic.job4j_ru;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task3 {
    public static List<Integer> extractDuplicates(List<Integer> left, List<Integer> right) {
        Map<Integer, Integer> lefts = left.stream().collect(Collectors.toMap(Function.identity(), Function.identity()));

        return right.stream()
            .filter(key -> lefts.containsKey(key))
            .toList();
    }
}

