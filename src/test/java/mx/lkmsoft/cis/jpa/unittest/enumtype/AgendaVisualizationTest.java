package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.AgendaVisualization;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link AgendaVisualization} test class
 *
 * @author Maikel Guerra Ferrer
 */
class AgendaVisualizationTest {

    @Test
    void testGetValue() {
        assertEquals(AgendaVisualization.AGENDA, AgendaVisualization.getValue("AGENDA"));
        assertNull(AgendaVisualization.getValue(null));
        assertNull(AgendaVisualization.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "AGENDA, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = AgendaVisualization.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
