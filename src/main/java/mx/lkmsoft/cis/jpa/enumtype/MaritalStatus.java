package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "MaritalStatus")
public enum MaritalStatus {
    SINGLE, MARRIED, DIVORCED, COMMON_LAW, WIDOWED;

    public static MaritalStatus getValue(String maritalStatus) {
        try {
            if (StringUtils.hasValue(maritalStatus)) {
                return MaritalStatus.valueOf(maritalStatus);
            }
        } catch (IllegalArgumentException e) {
            log.error("Error trying to get MaritalStatus value from '{}'", maritalStatus);
        }
        return null;
    }

    public static boolean isValid(String maritalStatus) {
        return EnumUtils.isValidEnum(MaritalStatus.class, maritalStatus);
    }
}