package mx.lkmsoft.cis.jpa.enumtype;

import org.apache.commons.lang3.EnumUtils;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;

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
            log.error("Error trying to get Race value from '{}'", race);
        }
        return null;
    }

    public static boolean isValid(String race) {
        return EnumUtils.isValidEnum(Race.class, race);
    }
}