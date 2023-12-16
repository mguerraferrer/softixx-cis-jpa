package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.IntegerUtils;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "Race")
public enum Race {
    WHITE, MIXED, BLACK;

    public static Race getValue(String race) {
        try {
            if (StringUtils.hasValue(race)) {
                return Race.valueOf(race);
            }
        } catch (IllegalArgumentException e) {
            log.error("Get enum value error: {}", e.getMessage());
        }
        return null;
    }

    public static boolean isValid(String race) {
        return EnumUtils.isValidEnum(Race.class, race);
    }
}