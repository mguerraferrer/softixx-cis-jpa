package mx.lkmsoft.cis.jpa.embeddable;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Embeddable
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

	/* Getters and Setters */
	public String getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	public String getIpRangeStart() {
		return ipRangeStart;
	}

	public void setIpRangeStart(String ipRangeStart) {
		this.ipRangeStart = ipRangeStart;
	}

	public String getIpRangeEnd() {
		return ipRangeEnd;
	}

	public void setIpRangeEnd(String ipRangeEnd) {
		this.ipRangeEnd = ipRangeEnd;
	}
	
}