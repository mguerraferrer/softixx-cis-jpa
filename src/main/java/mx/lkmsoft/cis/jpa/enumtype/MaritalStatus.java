package mx.lkmsoft.cis.jpa.enumtype;

import mx.lkmsoft.cis.common.data.StringUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public enum MaritalStatus {
    SINGLE, MARRIED, DIVORCED, COMMON_LAW, WIDOWED;

    public static MaritalStatus getValue(String maritalStatus) {
        if (StringUtils.hasValue(maritalStatus)) {
            return MaritalStatus.valueOf(maritalStatus);
        }
        return null;
    }

}