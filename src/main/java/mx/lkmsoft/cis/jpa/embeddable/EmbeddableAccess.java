package mx.lkmsoft.cis.jpa.embeddable;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Embeddable
@Getter
@Setter
public class EmbeddableAccess {
	
	@Column(name = "working_days")
	private String workingDays;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Column(name = "ip_range_start")
	@Convert(converter = AttributeEncryptor.class)
	private String ipRangeStart;

	@Column(name = "ip_range_end")
	@Convert(converter = AttributeEncryptor.class)
	private String ipRangeEnd;
	
}