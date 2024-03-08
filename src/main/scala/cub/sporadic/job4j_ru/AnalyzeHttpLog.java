package cub.sporadic.job4j_ru;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AnalyzeHttpLog {
    public record Line(String level, String thread, String text) {
    }

    public static Map<String, Long> groupByLevel(List<Line> logs) {
        logs.stream().map()
        return Collections.emptyMap();
    }

    public static String maxByThread(List<Line> logs) {
        return "";
    }

    public static Map<String, Long> detailByThread(List<Line> logs, String thread,
                                                   List<String> orders) {
        return Collections.emptyMap();
    }
}
