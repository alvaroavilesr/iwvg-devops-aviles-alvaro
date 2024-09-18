package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    User userEmpty;
    User userFull;
    Fraction fraction1;
    Fraction fraction2;
    Fraction fraction3;

    @BeforeEach
    void setUp() {
        userEmpty = new User();
        fraction1 = new Fraction(2,5);
        fraction2 = new Fraction(5,2);
        userFull = new User("1", "Alvaro", "Aviles", List.of(fraction1, fraction2));
    }

    @Test
    @DisplayName("Test empty constructor")
    void testEmptyConstructor() {
        assertTrue(userEmpty.getFractions().isEmpty());
    }

    @Test
    @DisplayName("Test constructor")
    void testConstructor() {
        assertEquals("1", userFull.getId());
        assertEquals("Alvaro", userFull.getName());
        assertEquals("Aviles", userFull.getFamilyName());
        assertFalse(userFull.getFractions().isEmpty());
    }

    @Test
    @DisplayName("Test setName()")
    void testSetName() {
        userEmpty.setName("Alvaro");
        assertEquals("Alvaro", userEmpty.getName());
    }

    @Test
    @DisplayName("Test setFamilyName()")
    void testSetFamilyName() {
        userEmpty.setFamilyName("Aviles");
        assertEquals("Aviles", userEmpty.getFamilyName());
    }

    @Test
    @DisplayName("Test setFractions()")
    void testSetFractions() {
        userEmpty.setFractions(List.of(fraction1, fraction2));
        assertFalse(userEmpty.getFractions().isEmpty());
    }

    @Test
    @DisplayName("Test addFraction()")
    void testAddFraction() {
        fraction3 = new Fraction(100,5);
        userEmpty.addFraction(fraction3);

        assertFalse(userEmpty.getFractions().isEmpty());
        assertEquals(100, userEmpty.getFractions().get(0).getNumerator());
    }

    @Test
    @DisplayName("Test fullName()")
    void testFullName() {
        assertEquals("Alvaro Aviles", userFull.fullName());
    }

    @Test
    @DisplayName("Test initials()")
    void testInitials() {
        assertEquals("A.", userFull.initials());
    }
}
