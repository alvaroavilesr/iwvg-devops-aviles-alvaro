package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {

    Fraction fraction1;
    Fraction fraction2;

    @BeforeEach
    void setUp() {
        fraction1 = new Fraction();
        fraction2 = new Fraction(2,5);
    }

    @Test
    @DisplayName("Test empty constructor")
    void testEmptyConstructor() {
        assertEquals(1, fraction1.getNumerator());
        assertEquals(1, fraction1.getDenominator());
    }

    @Test
    @DisplayName("Test constructor")
    void testConstructor() {
        assertEquals(2, fraction2.getNumerator());
        assertEquals(5, fraction2.getDenominator());
    }

    @Test
    @DisplayName("Test decimal()")
    void testDecimal() {
        assertEquals((double) 2 / 5, fraction2.decimal());
    }
}
