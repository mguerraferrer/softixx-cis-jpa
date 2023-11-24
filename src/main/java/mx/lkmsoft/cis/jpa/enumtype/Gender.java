package mx.lkmsoft.cis.jpa.enumtype;

import mx.lkmsoft.cis.common.data.StringUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public enum Gender {
    MALE, FEMALE, UNKNOWN;

    public static Gender getValue(String gender) {
        if (StringUtils.hasValue(gender)) {
            return Gender.valueOf(gender);
        }
        return null;
    }

}