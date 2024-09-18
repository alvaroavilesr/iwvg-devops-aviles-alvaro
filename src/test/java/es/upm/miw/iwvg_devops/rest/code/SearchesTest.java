package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SearchesTest {

    @InjectMocks
    private Searches searches;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Test findFirstProperFractionByUserId(String id)")
    void testFindFirstProperFractionByUserId() {
        Fraction result = searches.findFirstProperFractionByUserId("1");
        assertEquals(0, result.getNumerator());
        assertEquals(1, result.getDenominator());
    }

    @Test
    @DisplayName("Test findFirstProperFractionByUserId(String id) null")
    void testFindFirstProperFractionByUserIdNull() {
        Fraction result = searches.findFirstProperFractionByUserId("8");
        assertEquals(null, result);
    }

}
