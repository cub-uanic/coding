package cub.sporadic.job4j_ru;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Map<String, Long> originMap = Arrays.stream(origin.split("[\\s.,:;!?]+"))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> lineMap = Arrays.stream(line.split("[\\s.,:;!?]+"))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry<String, Long> entry : lineMap.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();

            if (!originMap.containsKey(key)) {
                return false;
            }

            Long orig = originMap.get(key);
            if (orig < value) {
                return false;
            }
        }
        return true;
    }
}
