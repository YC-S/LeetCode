package contest.leetcode.单周赛._227;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P5674_LargestMergeOfTwoStringsTest {
    private P5674_LargestMergeOfTwoStrings test;

    @BeforeEach
    void setUp() {
        test = new P5674_LargestMergeOfTwoStrings();
    }

    @AfterEach
    void tearDown() {
        test = null;
    }

    @Test
    void largestMerge() {
        // assertEquals(test.largestMerge("cabaa", "bcaaa"), "cbcabaaaaa");
        // assertEquals(test.largestMerge("abcabc", "abdcaba"), "abdcabcabcaba");
        assertEquals(test.largestMerge("guguuuuuuuuuuuuuuguguuuuguug", "gguggggggguuggguugggggg"), "guguuuuuuuuuuuuuuguguuuuguugguggggggguuggguuggggggg");
    }
}