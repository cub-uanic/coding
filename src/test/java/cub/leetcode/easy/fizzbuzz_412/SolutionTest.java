package cub.leetcode.easy.fizzbuzz_412;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(3, List.of("1","2","Fizz")),
            Arguments.of(5, List.of("1","2","Fizz","4","Buzz")),
            Arguments.of(15, List.of("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void fizzBuzz(int input, List<String> expected) {
        Solution solution = new Solution();
        List<String> actual = solution.fizzBuzz(input);
        assertTrue(actual.containsAll(expected));
    }
}
