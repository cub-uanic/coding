package cub.leetcode.medium.iteratorforcombination;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationIteratorTest {
    @Test
    void combinationIteratorTest_abc_2() {
        CombinationIterator itr = new CombinationIterator("abc", 2);

        assertEquals("ab", itr.next());
        assertTrue(itr.hasNext());
        assertEquals("ac", itr.next());
        assertTrue(itr.hasNext());
        assertEquals("bc", itr.next());
        assertFalse(itr.hasNext());
    }

    @Test
    void combinationIteratorTest_chp_1() {
        CombinationIterator itr = new CombinationIterator("chp", 1);

        assertTrue(itr.hasNext());
        assertEquals("c", itr.next());
        assertTrue(itr.hasNext());
        assertTrue(itr.hasNext());
        assertEquals("h", itr.next());
        assertEquals("p", itr.next());
        assertFalse(itr.hasNext());
        assertFalse(itr.hasNext());
        assertFalse(itr.hasNext());
        assertFalse(itr.hasNext());
    }
}
