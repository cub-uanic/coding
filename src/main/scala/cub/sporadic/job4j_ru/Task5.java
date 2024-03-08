package cub.sporadic.job4j_ru;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task5 {
    public static List<Integer> multiAssign(List<Task> tasks) {
        Map<Task, Long> taskToAssignee = tasks
            .stream()
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
            ));

        return taskToAssignee.entrySet().stream()
            .filter(e -> e.getValue() > 1)
            .map(t -> t.getKey().assignId)
            .toList();
    }

    public record Task(Integer taskId, Integer assignId) {
    }
}
