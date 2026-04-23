package cub.leetcode.easy.destinationcity_1436;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(List.of(
                List.of("London", "New York"),
                List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo")
            ), "Sao Paulo"),
            Arguments.of(List.of(
                List.of("B", "C"),
                List.of("D", "B"),
                List.of("C", "A")
            ), "A"),
            Arguments.of(List.of(
                List.of("A", "Z")
            ), "Z")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void destCitySolution1(List<List<String>> paths, String expected) {
        checkSolution(new Solution1(), paths, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void destCitySolution2(List<List<String>> paths, String expected) {
        checkSolution(new Solution2(), paths, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void destCitySolution3(List<List<String>> paths, String expected) {
        checkSolution(new Solution3(), paths, expected);
    }

    private void checkSolution(Solution solution, List<List<String>> paths, String expected) {
        assertEquals(expected, solution.destCity(paths));
    }
}
