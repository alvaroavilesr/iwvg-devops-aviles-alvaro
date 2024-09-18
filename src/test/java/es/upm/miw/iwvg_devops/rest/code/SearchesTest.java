package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class SearchesTest {

    @InjectMocks
    private Searches searches;

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
        assertNull(result);
    }

    @Test
    @DisplayName("Test findFractionDivisionByUserId(String id)")
    void testFindFractionDivisionByUserId() {
        Fraction result = searches.findFractionDivisionByUserId("4");
        assertEquals(8, result.getNumerator());
        assertEquals(8, result.getDenominator());
    }

    @Test
    @DisplayName("Test findDecimalImproperFractionByUserName(String name)")
    void TestFindDecimalImproperFractionByUserName() {
        Stream<Double> result = searches.findDecimalImproperFractionByUserName("Oscar");
        List<Double> resultList = result.toList();
        assertEquals(2.0, resultList.get(0));
        assertEquals(-0.5, resultList.get(1));
    }
}
