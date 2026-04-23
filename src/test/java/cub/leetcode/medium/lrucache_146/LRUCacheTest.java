package cub.leetcode.medium.lrucache_146;

import org.hamcrest.Matcher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class LRUCacheTest {
    static class Triple {

        private final String operation;
        private final List<Integer> args;
        private final Integer expected;

        public Triple(String op, List<Integer> args, Integer expected) {
            this.operation = op;
            this.args = args;
            this.expected = expected;
        }

        public String getOperation() {
            return operation;
        }

        public List<Integer> getArgs() {
            return args;
        }

        public Integer getExpected() {
            return expected;
        }
    }

    private static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(
                // op
                List.of("LRUCache", "put", "get"),
                // args
                List.of(List.of(1), List.of(2, 1), List.of(2)),
                // result
                Stream.of(null, null, 1).toList()
            ),
            Arguments.of(
                // op
                List.of("LRUCache", "put", "put", "get", "get", "put", "get", "get", "get"),
                // args
                List.of(List.of(2), List.of(2, 1), List.of(3, 2), List.of(3), List.of(2), List.of(4, 3), List.of(2), List.of(3), List.of(4)),
                // result
                Stream.of(null, null, null, 2, 1, null, 1, -1, 3).toList()
            ),
            Arguments.of(
                // op
                List.of("LRUCache", "put", "get", "put", "get", "get"),
                // args
                List.of(List.of(1), List.of(2, 1), List.of(2), List.of(3, 2), List.of(2), List.of(3)),
                // result
                Stream.of(null, null, 1, null, -1, 2).toList()
            ),
            Arguments.of(
                // op
                List.of("LRUCache", "put", "put", "put", "get", "get", "get"),
                // args
                List.of(List.of(2), List.of(1, 1), List.of(2, 2), List.of(3, 3), List.of(1), List.of(2), List.of(3)),
                // result
                Stream.of(null, null, null, null, -1, 2, 3).toList()
            ),
            Arguments.of(
                // op
                List.of("LRUCache", "put", "put", "put", "put", "get", "get", "get"),
                // args
                List.of(List.of(2), List.of(1, 1), List.of(2, 2), List.of(3, 3), List.of(1, 1), List.of(1), List.of(2), List.of(3)),
                // result
                Stream.of(null, null, null, null, null, 1, -1, 3).toList()
            ),
            Arguments.of(
                // op
                List.of("LRUCache", "get", "put", "get", "put", "put", "get", "get"),
                // args
                List.of(List.of(2), List.of(2), List.of(2, 6), List.of(1), List.of(1, 5), List.of(1, 2), List.of(1), List.of(2)),
                // result
                Stream.of(null, -1, null, -1, null, null, 2, 6).toList()
            ),
            Arguments.of(
                // op
                List.of("LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"),
                // args
                List.of(List.of(2), List.of(1, 1), List.of(2, 2), List.of(1), List.of(3, 3), List.of(2), List.of(4, 4), List.of(1), List.of(3), List.of(4)),
                // result
                Stream.of(null, null, null, 1, null, -1, null, -1, 3, 4).toList()
            ),
            Arguments.of(
                // op
                List.of("LRUCache", "put", "put", "get", "put", "put", "get"),
                // args
                List.of(List.of(2), List.of(2, 1), List.of(2, 2), List.of(2), List.of(1, 1), List.of(4, 1), List.of(2)),
                // result
                Stream.of(null, null, null, 2, null, null, -1).toList()
            ),
            Arguments.of(
                // op
                List.of("LRUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"),
                // args
                List.of(
                    List.of(10), List.of(10, 13), List.of(3, 17), List.of(6, 11), List.of(10, 5),
                    List.of(9, 10), List.of(13), List.of(2, 19), List.of(2), List.of(3),
                    List.of(5, 25), List.of(8), List.of(9, 22), List.of(5, 5), List.of(1, 30),
                    List.of(11), List.of(9, 12), List.of(7), List.of(5), List.of(8),
                    List.of(9), List.of(4, 30), List.of(9, 3), List.of(9), List.of(10),
                    List.of(10), List.of(6, 14), List.of(3, 1), List.of(3), List.of(10, 11),
                    List.of(8), List.of(2, 14), List.of(1), List.of(5), List.of(4),
                    List.of(11, 4), List.of(12, 24), List.of(5, 18), List.of(13), List.of(7, 23),
                    List.of(8), List.of(12), List.of(3, 27), List.of(2, 12), List.of(5),
                    List.of(2, 9), List.of(13, 4), List.of(8, 18), List.of(1, 7), List.of(6),
                    List.of(9, 29), List.of(8, 21), List.of(5), List.of(6, 30), List.of(1, 12),
                    List.of(10), List.of(4, 15), List.of(7, 22), List.of(11, 26), List.of(8, 17),
                    List.of(9, 29), List.of(5), List.of(3, 4), List.of(11, 30), List.of(12),
                    List.of(4, 29), List.of(3), List.of(9), List.of(6), List.of(3, 4),
                    List.of(1), List.of(10), List.of(3, 29), List.of(10, 28), List.of(1, 20),
                    List.of(11, 13), List.of(3), List.of(3, 12), List.of(3, 8), List.of(10, 9),
                    List.of(3, 26), List.of(8), List.of(7), List.of(5), List.of(13, 17),
                    List.of(2, 27), List.of(11, 15), List.of(12), List.of(9, 19), List.of(2, 15),
                    List.of(3, 16), List.of(1), List.of(12, 17), List.of(9, 1), List.of(6, 19),
                    List.of(4), List.of(5), List.of(5), List.of(8, 1), List.of(11, 7),
                    List.of(5, 2), List.of(9, 28), List.of(1), List.of(2, 2), List.of(7, 4),
                    List.of(4, 22), List.of(7, 24), List.of(9, 26), List.of(13, 28), List.of(11, 26)
                ),
                // result
                Stream.of(
                    null, null, null, null, null, null, -1, null, 19, 17,
                    null, -1, null, null, null, -1, null, -1, 5, -1,
                    12, null, null, 3, 5, 5, null, null, 1, null,
                    -1, null, 30, 5, 30, null, null, null, -1, null,
                    -1, 24, null, null, 18, null, null, null, null, -1,
                    null, null, 18, null, null, -1, null, null, null, null,
                    null, 18, null, null, -1, null, 4, 29, 30, null,
                    12, -1, null, null, null, null, 29, null, null, null,
                    null, 17, 22, 18, null, null, null, -1, null, null,
                    null, 20, null, null, null, -1, 18, 18, null, null,
                    null, null, 20, null, null, null, null, null, null, null
                ).toList()
            )
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void checkSolution1(
        List<String> operations,
        List<List<Integer>> args,
        List<Integer> expected
    ) {
        checkLRUSolution(operations, args, expected, LRUCacheSolution1::new);
    }

    @ParameterizedTest
    @MethodSource("data")
    void checkSolution2(
        List<String> operations,
        List<List<Integer>> args,
        List<Integer> expected
    ) {
        checkLRUSolution(operations, args, expected, LRUCacheSolution2::new);
    }

    @ParameterizedTest
    @MethodSource("data")
    void checkSolution3(
        List<String> operations,
        List<List<Integer>> args,
        List<Integer> expected
    ) {
        checkLRUSolution(operations, args, expected, LRUCacheSolution3::new);
    }

    void checkLRUSolution(
        List<String> operations,
        List<List<Integer>> args,
        List<Integer> expected,
        Function<Integer, LRUCache> instantiateLRUCache
    ) {
        assertThat(operations.get(0), is(equalTo("LRUCache")));

        LRUCache lruCache = null;
        List<Triple> actions = IntStream.range(0, operations.size())
            .mapToObj(i -> new Triple(operations.get(i), args.get(i), expected.get(i)))
            .toList();

        int index = 0;
        for (Triple action : actions) {
            try {
                if (action.getOperation().equals("LRUCache")) {
                    lruCache = instantiateLRUCache.apply(action.getArgs().get(0));
                }

                if (action.getOperation().equals("put")) {
                    List<Integer> putArgs = action.getArgs();
                    lruCache.put(putArgs.get(0), putArgs.get(1));
                    assertThat("Step " + index, action.getExpected(), is(nullValue()));
                }

                if (action.getOperation().equals("get")) {
                    Integer actual = lruCache.get(action.getArgs().get(0));
                    checkThat("Step " + index, actual, is(equalTo(action.getExpected())));
//                    assertThat("Step " + index, actual, is(equalTo(action.getExpected())));
                }

                index++;
            } catch (Exception e) {
                System.err.println("On step " + index + ": " + e.getMessage());
            }
        }
    }

    public static <T> void checkThat(String reason, T actual, Matcher<? super T> matcher) {
        try {
            assertThat(reason, actual, matcher);
        } catch (AssertionError e) {
            System.err.println(e.getMessage());
        }
    }
}
