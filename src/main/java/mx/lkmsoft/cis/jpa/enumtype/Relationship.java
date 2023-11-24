package mx.lkmsoft.cis.jpa.enumtype;

import mx.lkmsoft.cis.common.data.StringUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
public enum Relationship {
	FATHER, MOTHER, PAT_GRANDFATHER, PAT_GRANDMOTHER, MAT_GRANDFATHER, MAT_GRANDMOTHER, SIBLINGS, UNCLES_AUNTS, COUSINS,
	PAT_GREAT_GRANDFATHER, PAT_GREAT_GRANDMOTHER, MAT_GREAT_GRANDFATHER, MAT_GREAT_GRANDMOTHER;

	public static Relationship getValue(String relationShip) {
		if (StringUtils.hasValue(relationShip)) {
			return Relationship.valueOf(relationShip);
		}
		return null;
	}
}