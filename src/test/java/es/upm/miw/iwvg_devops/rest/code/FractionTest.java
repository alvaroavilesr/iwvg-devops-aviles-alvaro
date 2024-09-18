package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    private Fraction fraction1;
    private Fraction fraction2;
    private Fraction fraction3;
    private Fraction fraction4;
    private Fraction fractionEq1;
    private Fraction fractionEq2;

    @BeforeEach
    void setUp() {
        fraction1 = new Fraction();
        fraction2 = new Fraction(2,5);
        fraction3 = new Fraction(4,5);
        fraction4 = new Fraction(5,4);
        fractionEq1 = new Fraction(5,10);
        fractionEq2 = new Fraction(10,20);
    }

    @Test
    @DisplayName("Test setNumerator()")
    void testSetNumerator() {
        fraction1.setNumerator(1);
        assertEquals(1, fraction1.getNumerator());
    }

    @Test
    @DisplayName("Test setDenominator()")
    void testSetDenominator() {
        fraction1.setDenominator(1);
        assertEquals(1, fraction1.getDenominator());
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

    @Test
    @DisplayName("Test isProper()")
    void testIsProper() {
        assertTrue(fraction2.isProper());
    }

    @Test
    @DisplayName("Test isProper() false")
    void testIsProperFalse() {
        assertFalse(fraction4.isProper());
    }

    @Test
    @DisplayName("Test isImproper()")
    void testIsImproper() {
        assertFalse(fraction2.isImproper());
    }

    @Test
    @DisplayName("Test isImproper() true")
    void testIsImproperTrue() {
        assertTrue(fraction4.isImproper());
    }

    @Test
    @DisplayName("Test isEquivalent()")
    void testIsEquivalent() {
        assertTrue(fractionEq1.isEquivalent(fractionEq2));
    }

    @Test
    @DisplayName("Test isEquivalent() false")
    void testIsEquivalentFalse() {
        assertFalse(fraction1.isEquivalent(fraction2));
    }

    @Test
    @DisplayName("Test add() with same denominator")
    void testAddSameDenominator() {
        Fraction result = fraction2.add(fraction3);
        assertEquals(6, result.getNumerator());
        assertEquals(5, result.getDenominator());
    }

    @Test
    @DisplayName("Test add() with different denominator")
    void testAddDifferentDenominator() {
        Fraction result = fraction1.add(fraction3);
        assertEquals(9, result.getNumerator());
        assertEquals(5, result.getDenominator());
    }

    @Test
    @DisplayName("Test multiply()")
    void testMultiply() {
        Fraction result = fraction2.multiply(fraction3);
        assertEquals(8, result.getNumerator());
        assertEquals(25, result.getDenominator());
    }

    @Test
    @DisplayName("Test divide()")
    void testDivide() {
        Fraction result = fraction2.divide(fraction3);
        assertEquals(10, result.getNumerator());
        assertEquals(20, result.getDenominator());
    }
}
