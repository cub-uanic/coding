package cub.sporadic.job4j_ru;

import kotlin.Pair;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
### Where

https://job4j.ru/topics/42/task_code/552/new_task

### Task

В этом задании нужно реализовать методы для анализа лога от HTTP сервера.

Входные данные является список из объектов Line. Объект Line имеет три поля: уровень лога, имя нити и текст сообщения.

Необходимо реализовать методы:

groupByLebel - метод должен вернуть карту, где ключ - это уровень лога, а значение - количество сообщений.

maxByThread - метод должен вернуть имя нити, которая больше всех записала логов.

detailByThread - метод должен вернуть карту, где ключ - это уровень лога, а значение - количество сообщений.
Этот метод так же принимает имя нити для который нужный логи и список по которому нужно вывести уровени.

 */

public class AnalyzeHttpLog {
    public record Line(String level, String thread, String text) {
    }

    public static Map<String, Long> groupByLevel(List<Line> logs) {
        return logs
            .stream()
            .collect(Collectors.groupingBy(Line::level, Collectors.counting()));
    }

    public static String maxByThread(List<Line> logs) {
        return IntStream.range(0, logs.size())
            .mapToObj(idx -> new Pair<>(idx, logs.get(idx).thread.length()))
            .max(Comparator.comparingInt(Pair::component2))
            .map(pair -> logs.get(pair.component1()).thread)
            .orElse("");
    }

    public static Map<String, Long> detailByThread(
        List<Line> logs,
        String thread,
        List<String> orders
    ) {
        return logs
            .stream()
            .collect(Collectors.groupingBy(Line::level, Collectors.counting()));
    }
}
