package contest.leetcode.单周赛._227;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P5673_MaximumScoreFromRemovingStonesTest {

    private P5673_MaximumScoreFromRemovingStones test;

    @BeforeEach
    void setUp() {
        test = new P5673_MaximumScoreFromRemovingStones();
    }

    @AfterEach
    void tearDown() {
        test = null;
    }

    @Test
    void maximumScore() {
        assertEquals(test.maximumScore(2, 4, 6), 6);
        assertEquals(test.maximumScore(4, 4, 6), 7);
        assertEquals(test.maximumScore(1, 8, 8), 8);
    }
}