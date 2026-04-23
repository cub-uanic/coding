package cub.sporadic.job4j_ru;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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

class AnalyzeHttpLogTest {

    @Test
    void whenGroupByLevel() {
        var logs = List.of(
            new AnalyzeHttpLog.Line("ERROR", "[threads [qbxb [bbb]] - 1]", "yaee ybz"),
            new AnalyzeHttpLog.Line("ERROR", "[threads [xcde [aqx]] - 0]", "wyce"),
            new AnalyzeHttpLog.Line("ERROR", "[threads [wcxf [czed [ayya [fye]]]] - 0]", "eaba yzd"),
            new AnalyzeHttpLog.Line("DEBUG", "[threads [zqfz [wbye [zfq]]] - 1]", "[cz] bxa")
        );
        assertThat(AnalyzeHttpLog.groupByLevel(logs),
            is(Map.of("ERROR", 3L, "DEBUG", 1L))
        );
    }

    @Test
    void whenMaxByThread() {
        var logs = List.of(
            new AnalyzeHttpLog.Line("ERROR", "[threads [qbxb [bbb]] - 1]", "yaee ybze"),
            new AnalyzeHttpLog.Line("ERROR", "[threads [xcde [aqx]] - 0]", "wyce"),
            new AnalyzeHttpLog.Line("ERROR", "[threads [wcxf [czed [ayya [fye]]]] - 0]", "eaba yzd"),
            new AnalyzeHttpLog.Line("DEBUG", "[threads [zqfz [wbye [zfq]]] - 1]", "[cz] bxa")
        );
        assertThat(AnalyzeHttpLog.maxByThread(logs),
            is("[threads [wcxf [czed [ayya [fye]]]] - 0]")
        );
    }

    @Test
    void whenDetailByThread() {
        var logs = List.of(
            new AnalyzeHttpLog.Line("ERROR", "[threads [qbxb]]", "yaee ybze"),
            new AnalyzeHttpLog.Line("ERROR", "[threads [qbxb]]", "wyce"),
            new AnalyzeHttpLog.Line("ERROR", "[threads [qbxb]]", "eaba yzd"),
            new AnalyzeHttpLog.Line("DEBUG", "[threads [qbxb]]", "[cz] bxa")
        );
        assertThat(AnalyzeHttpLog.detailByThread(logs, "[threads [qbxb]]", List.of("ERROR", "WARNING")),
            is(Map.of("ERROR", 3L, "DEBUG", 1L))
        );
    }
}
