package cub.sporadic.job4j_ru;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task4 {
    public static List<Integer> extractUnique(List<Integer> left, List<Integer> right) {
        Set<Integer> containsAll = new HashSet<>();
        containsAll.addAll(left);
        containsAll.addAll(right);

        return containsAll.stream()
            .filter(i -> left.contains(i) ^ right.contains(i))
            .toList();
    }
}

