package company.byteDance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P726_NumberOfAtomsTest {
    String formula1 = "H2O";
    String formula2 = "Mg(OH)2";
    String formula3 = "K4(ON(SO3)2)2";
    String formula4 = "Be32";
    private P726_NumberOfAtoms test;

    @BeforeEach
    void setUp() {
        test = new P726_NumberOfAtoms();
    }

    @AfterEach
    void tearDown() {
        test = null;
    }

    @Test
    void countOfAtoms() {
        assertEquals(test.countOfAtoms(formula1), "H2O");
        assertEquals(test.countOfAtoms(formula2), "H2MgO2");
        assertEquals(test.countOfAtoms(formula3), "K4N2O14S4");
        assertEquals(test.countOfAtoms(formula4), "Be32");
    }
}