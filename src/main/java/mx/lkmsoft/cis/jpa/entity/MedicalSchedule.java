package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.common.datetime.LocalDateUtils;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "medical_schedule"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "medical_schedule", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.medical_schedule_id_seq", allocationSize = 1)
public class MedicalSchedule extends BaseEntity {

	@Column(name = "doctor_id")
	private Long doctorId;

	@Column(name = "healthcare_center_id")
	private Long healthcareCenterId;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "medicalSchedule", targetEntity = Planning.class)
	private List<Planning> plannings;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "medicalSchedule", targetEntity = NonWorkingDay.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<NonWorkingDay> nonWorkingDays;

	public MedicalSchedule withHealthcareCenter(Long doctorId, Long healthcareCenterId, LocalDate endDate) {
		this.doctorId = doctorId;
		this.healthcareCenterId = healthcareCenterId;
		this.endDate = endDate;
		this.active = LocalDateUtils.isFutureOrPresent(endDate);
		return this;
	}

	/* Getters and Setters */
	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getHealthcareCenterId() {
		return healthcareCenterId;
	}

	public void setHealthcareCenterId(Long healthcareCenterId) {
		this.healthcareCenterId = healthcareCenterId;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Planning> getPlannings() {
		if (plannings == null) {
			plannings = new ArrayList<>();
		}
		return plannings;
	}

	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}
	
	public List<NonWorkingDay> getNonWorkingDays() {
		if (nonWorkingDays == null) {
			nonWorkingDays = new ArrayList<>();
		}
		return nonWorkingDays;
	}

	public void setNonWorkingDays(List<NonWorkingDay> nonWorkingDays) {
		this.nonWorkingDays = nonWorkingDays;
	}
	
	public void addNonWorkingDays(LocalDate nwd) {
		if (nonWorkingDays == null) {
			nonWorkingDays = new ArrayList<>();
		}
		this.nonWorkingDays.add(new NonWorkingDay(this, nwd));
	}
	
	public void addNonWorkingDays(List<NonWorkingDay> nonWorkingDays) {
		if (this.nonWorkingDays != null) {
			this.nonWorkingDays.clear();
			this.nonWorkingDays.addAll(nonWorkingDays);
		}
	}

	/* toString */
	@Override
	public String toString() {
		return "MedicalSchedule [id=" + id + ", doctorId=" + doctorId + ", healthcareCenterId=" + healthcareCenterId + ", endDate=" + endDate + ", active=" + active + "]";
	}

}