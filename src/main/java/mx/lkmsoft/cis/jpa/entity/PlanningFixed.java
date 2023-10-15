package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
import mx.lkmsoft.cis.common.collection.ListUtils;

/**
 * Persistent class for entity stored in table "planning_fixed"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "planning_fixed", schema = "agenda")
public class PlanningFixed {
	
	@Id
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private Planning planning;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Column(name = "total_patients")
	private Integer totalPatients;

	@Column(name = "total_extra_slot")
	private Integer totalExtraSlot;

	@Column(name = "days")
	private String days;
	
	@Version
	private Long version;

	public PlanningFixed() {
	}

	public PlanningFixed(LocalTime startTime, LocalTime endTime, Integer totalPatients, Integer totalExtraSlot,
			String days) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalPatients = totalPatients;
		this.totalExtraSlot = totalExtraSlot;
		this.days = days;
	}
	
	public static PlanningFixed clone(PlanningFixed planningFixed) {
		return new PlanningFixed(planningFixed.getStartTime(), planningFixed.getEndTime(),
				planningFixed.getTotalPatients(), planningFixed.getTotalExtraSlot(), planningFixed.getDays());
	}

	/* Getters and Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
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

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Transient
	public boolean isAllWeek() {
		return ListUtils.toList(days).size() == 7;
	}
	
	@Transient
	public List<String> weekDays() {
		return ListUtils.toList(days);
	}

	/* toString */
	@Override
	public String toString() {
		return "PlanningFixed [id=" + id + ", planning=" + planning.getId() + ", startTime=" + startTime + ", endTime="
				+ endTime + ", totalPatients=" + totalPatients + ", totalExtraSlot=" + totalExtraSlot + ", days=" + days
				+ ", version=" + version + "]";
	}

}