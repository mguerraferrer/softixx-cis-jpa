package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.val;
import mx.lkmsoft.cis.common.assertion.AssertUtils;
import mx.lkmsoft.cis.common.collection.ListUtils;
import mx.lkmsoft.cis.common.data.CodeGeneratorUtils;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "medical_schedule"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "medical_schedule", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.medical_schedule_seq", allocationSize = 1)
public class MedicalSchedule extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "healthcare_center_id", referencedColumnName = "id")
	private HealthcareCenter healthcareCenter;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "code")
	private String code;

	@Version
	private Long version;
	
	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalSchedule", targetEntity = Planning.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Planning> plannings;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalSchedule", targetEntity = NonWorkingDay.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<NonWorkingDay> nonWorkingDays;

	public MedicalSchedule() {
	}

	public MedicalSchedule(Doctor doctor, HealthcareCenter healthcareCenter, LocalDate endDate) {
		this.doctor = doctor;
		this.healthcareCenter = healthcareCenter;
		this.endDate = endDate;
		this.code = CodeGeneratorUtils.asString();
		this.active = true;
	}

	/* Getters and Setters */
	public HealthcareCenter getHealthcareCenter() {
		return healthcareCenter;
	}

	public void setHealthcareCenter(HealthcareCenter healthcareCenter) {
		this.healthcareCenter = healthcareCenter;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
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
	
	public void addPlanning(Planning planning) {
		if (this.plannings == null) {
			this.plannings = new ArrayList<>();
		}
		this.plannings.add(planning);
	}
	
	public void addPlanning(List<Planning> plannings) {
		if (this.plannings != null) {
			this.plannings.clear();
			this.plannings.addAll(plannings);
		}
	}
	
	public void updatePlanning(Planning planning) {
		val planningList = getPlannings().stream()
									  	 .filter(pl -> !pl.getCode().equals(planning.getCode()))
									  	 .collect(Collectors.toList());
		planningList.add(planning);
		addPlanning(planningList);
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
		if (AssertUtils.nonNull(this.nonWorkingDays)) {
			nonWorkingDays = ListUtils.merge(this.nonWorkingDays, nonWorkingDays);
			this.nonWorkingDays.clear();
		}
		getNonWorkingDays().addAll(nonWorkingDays);
	}

	/* toString */
	@Override
	public String toString() {
		return "MedicalSchedule [id=" + id + ", doctor=" + doctor.getId() + ", healthcareCenter="
				+ healthcareCenter.getId() + ", endDate=" + endDate + ", code=" + code + ", version=" + version
				+ ", active=" + active + "]";
	}

}