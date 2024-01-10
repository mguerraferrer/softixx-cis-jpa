package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "Relationship")
public enum Relationship {
	FATHER, MOTHER, PAT_GRANDFATHER, PAT_GRANDMOTHER, MAT_GRANDFATHER, MAT_GRANDMOTHER, SIBLINGS, UNCLES_AUNTS, COUSINS,
	PAT_GREAT_GRANDFATHER, PAT_GREAT_GRANDMOTHER, MAT_GREAT_GRANDFATHER, MAT_GREAT_GRANDMOTHER;

	public static Relationship getValue(String relationShip) {
		try {
			if (StringUtils.hasValue(relationShip)) {
				return Relationship.valueOf(relationShip);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get Relationship value from '{}'", relationShip);
		}
		return null;
	}

	public static boolean isValid(String relationShip) {
		return EnumUtils.isValidEnum(Relationship.class, relationShip);
	}
}