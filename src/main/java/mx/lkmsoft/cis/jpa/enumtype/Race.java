package mx.lkmsoft.cis.jpa.enumtype;

import mx.lkmsoft.cis.common.data.StringUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public enum Race {
    WHITE, MIXED, BLACK;

    public static Race getValue(String race) {
        if (StringUtils.hasValue(race)) {
            return Race.valueOf(race);
        }
        return null;
    }
}