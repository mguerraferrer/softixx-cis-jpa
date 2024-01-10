package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "Gender")
public enum Gender {
    MALE, FEMALE, UNKNOWN;

    public static Gender getValue(String gender) {
        try {
            if (StringUtils.hasValue(gender)) {
                return Gender.valueOf(gender);
            }
        } catch (IllegalArgumentException e) {
            log.error("Error trying to get Gender value from '{}'", gender);
        }
        return null;
    }

    public static boolean isValid(String gender) {
        return EnumUtils.isValidEnum(Gender.class, gender);
    }
}