package company.byteDance.ella.lark;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P1477Test {

    private P1477 test;

    @BeforeEach
    void setUp() {
        test = new P1477();
    }

    @AfterEach
    void tearDown() {
        test = null;
    }

    @Test
    void minSumOfLengths() {
        int[] arr = {3, 2, 2, 4, 3};
        int target = 3;
        assertEquals(P1477.minSumOfLengths(arr, target), 2);
    }
}