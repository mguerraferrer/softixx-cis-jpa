package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import mx.lkmsoft.cis.common.datetime.WeekDay;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "planning_daily"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "planning_daily", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.planning_daily_seq", allocationSize = 1)
public class PlanningDaily extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "planning_id", referencedColumnName = "id")
	private Planning planning;

	@Column(name = "day")
	@Enumerated(EnumType.STRING)
	private WeekDay day;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Column(name = "total_patients")
	private Integer totalPatients;

	@Column(name = "total_extra_slot")
	private Integer totalExtraSlot;
	
	@Version
	private Long version;

	public PlanningDaily() {
	}

	public PlanningDaily(WeekDay day, LocalTime startTime, LocalTime endTime, Integer totalPatients,
			Integer totalExtraSlot) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalPatients = totalPatients;
		this.totalExtraSlot = totalExtraSlot;
	}
	
	public PlanningDaily(Planning planning, WeekDay day, LocalTime startTime, LocalTime endTime, Integer totalPatients,
			Integer totalExtraSlot) {
		this.planning = planning;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalPatients = totalPatients;
		this.totalExtraSlot = totalExtraSlot;
	}

	/* Getters and Setters */
	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	public WeekDay getDay() {
		return day;
	}

	public void setDay(WeekDay day) {
		this.day = day;
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

	public Integer getTotalPatients() {
		return totalPatients;
	}

	public void setTotalPatients(Integer totalPatients) {
		this.totalPatients = totalPatients;
	}

	public Integer getTotalExtraSlot() {
		return totalExtraSlot;
	}

	public void setTotalExtraSlot(Integer totalExtraSlot) {
		this.totalExtraSlot = totalExtraSlot;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "PlanningDaily [id=" + id + ", planning=" + planning.getId() + ", day=" + day + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", totalPatients=" + totalPatients + ", totalExtraSlot=" + totalExtraSlot
				+ ", version=" + version + "]";
	}

}