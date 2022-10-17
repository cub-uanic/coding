package cub.leetcode.easy.arrangingcoins;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(5, 2),
            Arguments.of(8, 3),
            Arguments.of(1804289383, 60070)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void arrangeCoins(int input, int expected) {
        Solution solution = new Solution();
        assertEquals(expected, solution.arrangeCoins(input));
    }
}
