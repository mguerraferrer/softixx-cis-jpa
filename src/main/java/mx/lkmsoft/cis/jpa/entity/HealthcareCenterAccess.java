package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * Persistent class for entity stored in table "participant"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "healthcare_center_access", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.healthcare_center_access_id_seq", allocationSize = 1)
public class HealthcareCenterAccess extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "healthcare_center_id", referencedColumnName = "id")
	private HealthcareCenter healthcareCenter;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Column(name = "working_day")
	private String workingDay;

	@Column(name = "working_days")
	private String workingDays;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Column(name = "ip")
	private String ip;

	@Column(name = "ip_range_start")
	@Convert(converter = AttributeEncryptor.class)
	private String ipRangeStart;

	@Column(name = "ip_range_end")
	@Convert(converter = AttributeEncryptor.class)
	private String ipRangeEnd;

	@Column(name = "active")
	private boolean active;

	public HealthcareCenterAccess() {
	}

	public HealthcareCenterAccess(HealthcareCenter healthcareCenter, User user) {
		this.healthcareCenter = healthcareCenter;
		this.user = user;
		this.active = true;
	}

	/* Getters and Setters */
	public HealthcareCenter getHealthcareCenter() {
		return healthcareCenter;
	}

	public void setHealthcareCenter(HealthcareCenter healthcareCenter) {
		this.healthcareCenter = healthcareCenter;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getWorkingDay() {
		return workingDay;
	}

	public void setWorkingDay(String workingDay) {
		this.workingDay = workingDay;
	}

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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/* toString */
	@Override
	public String toString() {
		return "HealthcareCenterAccess [id=" + id + ", healthcareCenter=" + healthcareCenter + ", user=" + user
				+ ", workingDay=" + workingDay + ", workingDays=" + workingDays + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", ip=" + ip + ", ipRangeStart=" + ipRangeStart + ", ipRangeEnd="
				+ ipRangeEnd + ", active=" + active + "]";
	}

}