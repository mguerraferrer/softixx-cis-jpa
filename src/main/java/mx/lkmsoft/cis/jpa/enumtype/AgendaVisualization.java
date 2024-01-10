package mx.lkmsoft.cis.jpa.enumtype;

import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.common.data.StringUtils;
import org.apache.commons.lang3.EnumUtils;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "AgendaVisualization")
public enum AgendaVisualization {
	AGENDA;

	public static AgendaVisualization getValue(String agendaVisualization) {
		try {
			if (StringUtils.hasValue(agendaVisualization)) {
				return AgendaVisualization.valueOf(agendaVisualization);
			}
		} catch (IllegalArgumentException e) {
			log.error("Error trying to get AgendaVisualization value from '{}'", agendaVisualization);
		}
		return null;
	}

	public static boolean isValid(String agendaVisualization) {
		return EnumUtils.isValidEnum(AgendaVisualization.class, agendaVisualization);
	}
}