package cub.sporadic.job4j_ru;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


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
            is(Map.of("ERROR", 3, "DEBUG", 1))
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
            is(Map.of("ERROR", 3, "DEBUG", 1))
        );
    }
}
