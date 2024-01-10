package mx.lkmsoft.cis.jpa.unittest.enumtype;

import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.enumtype.Relationship;
import mx.lkmsoft.cis.jpa.unittest.commondatatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link Relationship} test class
 *
 * @author Maikel Guerra Ferrer
 */
class RelationshipTest {

    @Test
    void testGetValue() {
        assertEquals(Relationship.MOTHER, Relationship.getValue("MOTHER"));
        assertEquals(Relationship.FATHER, Relationship.getValue("FATHER"));
        assertNull(Relationship.getValue(null));
        assertNull(Relationship.getValue("Invalid value"));
    }

    @ParameterizedTest
    @CsvSource({
        "SIBLINGS, true",
        "COUSINS, true",
        "null, false",
        "Invalid value, false"
    })
    void testIsValid(String value, boolean isAssert) {
        val result = Relationship.isValid(StringUtils.clean(value));
        DataTest.commonAssert(isAssert, result);
    }

}
