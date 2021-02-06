package company.byteDance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P864_ShortestPathToGetAllKeysTest {
    String[] input = {"@.a.#", "###.#", "b.A.B"};
    private P864_ShortestPathToGetAllKeys test;

    @BeforeEach
    void setUp() {
        test = new P864_ShortestPathToGetAllKeys();
    }

    @AfterEach
    void tearDown() {
        test = null;
    }

    @Test
    void shortestPathAllKeys() {
        assertEquals(test.shortestPathAllKeys(input), 8);
    }
}