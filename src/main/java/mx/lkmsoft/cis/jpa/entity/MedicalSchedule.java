package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "healthcare_center_id", referencedColumnName = "id")
	private HealthcareCenter healthcareCenter;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

	@Column(name = "end_date")
	private LocalDate endDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalSchedule", targetEntity = Planning.class)
	private List<Planning> plannings;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalSchedule", targetEntity = NonWorkingDay.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<NonWorkingDay> nonWorkingDays;

	public MedicalSchedule() {
	}

	public MedicalSchedule(Doctor doctor, HealthcareCenter healthcareCenter, LocalDate endDate) {
		this.doctor = doctor;
		this.healthcareCenter = healthcareCenter;
		this.endDate = endDate;
	}

	/* Getters and Setters */
	public HealthcareCenter getHealthcareCenter() {
		return healthcareCenter;
	}

	public void setHealthcareCenter(HealthcareCenter healthcareCenter) {
		this.healthcareCenter = healthcareCenter;
	}

	public Doctor getDoctorSpecialty() {
		return doctor;
	}

	public void setDoctorSpecialty(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Transient
	public boolean isActive() {
		return LocalDateUtils.isFutureOrPresent(endDate);
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
		return "MedicalSchedule [id=" + id + ", doctor=" + doctor.getId() + ", healthcareCenter="
				+ healthcareCenter.getId() + ", endDate=" + endDate + ", active=" + isActive() + "]";
	}

}