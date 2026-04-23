package cub.leetcode.hard.strongpasswordchecker;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of("a", 5),
            Arguments.of("aA1", 3),
            Arguments.of("1337C0d3", 0),
            Arguments.of("FFFFFFFFFFFFFFFAAAAAAAAAAAAAAAAAAAA111", 23),
            Arguments.of("AAAAAAAAAAAAAAAAAAAAFFFFFFFFFFFFFFF111", 23),
            Arguments.of("111FFFFFFFFFFFFFFFAAAAAAAAAAAAAAAAAAAA", 23),

            Arguments.of("FFxFFxFFxFFxFFxAA11x", 23),
            Arguments.of("FFAAxAAxAAxAAxAAxA11", 23),
            Arguments.of("FFxFFxFFxFFxFFxAAxAAxAAxAAxAAxAAxAA11x", 23),
            Arguments.of("FFxFFxFFxFFxFFAAxAAx", 23),

            Arguments.of("bbaaaaaaaaaaaaaaacccccc", 8),
            Arguments.of("aaaaaaaaaaaaaaabbcccccc", 8),
            Arguments.of("ccccccbbaaaaaaaaaaaaaaa", 8)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void strongPasswordChecker(String input, int expected) {
        Solution solution = new Solution();
        assertEquals(expected, solution.strongPasswordChecker(input));
    }
}
