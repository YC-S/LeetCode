package contest.leetcode.单周赛._227;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P5672_CheckIfArrayIsSortedAndRotatedTest {
    private P5672_CheckIfArrayIsSortedAndRotated test;

    @BeforeEach
    void setUp() {
        test = new P5672_CheckIfArrayIsSortedAndRotated();
    }

    @AfterEach
    void tearDown() {
        test = null;
    }

    @Test
    void check() {
        assertEquals(test.check(new int[]{3, 4, 5, 1, 2}), true);
        assertEquals(test.check(new int[]{2, 1, 3, 4}), false);
        assertEquals(test.check(new int[]{1, 2, 3}), true);
        assertEquals(test.check(new int[]{1, 1, 1}), true);
        assertEquals(test.check(new int[]{2, 1}), true);
        assertEquals(test.check(new int[]{2, 7, 4, 1, 2, 6, 2}), false);
    }
}