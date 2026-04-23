package cub.sporadic.job4j_ru;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

class Task3Test {

    @Test
    void whenNoDuplicate() {
        var right = List.of(1, 2, 3);
        var left = List.of(4, 5, 6);
        var expected = List.of();
        var result = Task3.extractDuplicates(left, right);
        assertThat(result, CoreMatchers.is(expected));
    }

    @Test
    void whenNoDuplicateButDuplicateValuesInRight() {
        var right = List.of(1, 2, 3, 1, 2, 3);
        var left = List.of(4, 5, 6);
        var expected = List.of();
        var result = Task3.extractDuplicates(left, right);
        assertThat(result, CoreMatchers.is(expected));
    }

    @Test
    void whenFullDuplicate() {
        var right = List.of(1, 2, 3);
        var left = List.of(1, 2, 3);
        var expected = List.of(1, 2, 3);
        var result = Task3.extractDuplicates(left, right);
        assertThat(result, CoreMatchers.is(expected));
    }

    @Test
    void whenLeftDuplicate() {
        var right = List.of(1, 2, 3);
        var left = List.of(1, 2, 3, 4, 5, 6);
        var expected = List.of(1, 2, 3);
        var result = Task3.extractDuplicates(left, right);
        assertThat(result, CoreMatchers.is(expected));
    }

    @Test
    void whenRightDuplicate() {
        var right = List.of(1, 2, 3, 4, 5, 6);
        var left = List.of(1, 2, 3);
        var expected = List.of(1, 2, 3);
        var result = Task3.extractDuplicates(left, right);
        assertThat(result, CoreMatchers.is(expected));
    }
}
