package cub.sporadic.job4j_ru;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class Task5Test {
    @Test
    void whenMulti() {
        var input = List.of(
            new Task5.Task(1, 1),
            new Task5.Task(1, 2),
            new Task5.Task(1, 1)
        );
        var expected = List.of(1);
        var result = Task5.multiAssign(input);
        assertThat(result, is(expected));
    }

    @Test
    void whenOnlyUnique() {
        var input = List.of(
            new Task5.Task(1, 1),
            new Task5.Task(1, 2),
            new Task5.Task(1, 3)
        );
        var expected = List.of();
        var result = Task5.multiAssign(input);
        assertThat(result, is(expected));
    }
}
