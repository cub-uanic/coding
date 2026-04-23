package cub.leetcode.easy.validanagram_242;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of("anagram", "nagaram", true),
            Arguments.of("rat", "car", false),
            Arguments.of("a".repeat(50000 - 1), "x".repeat(50000 - 1), false)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void isAnagram1(String s, String t, boolean expected) {
        checkSolution(new Solution1(), s, t, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isAnagram2(String s, String t, boolean expected) {
        checkSolution(new Solution2(), s, t, expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isAnagram3(String s, String t, boolean expected) {
        checkSolution(new Solution3(), s, t, expected);
    }

    private static void checkSolution(Solution solution, String s, String t, boolean expected) {
        boolean actual = solution.isAnagram(s, t);
        assertEquals(actual, expected);
    }
}
