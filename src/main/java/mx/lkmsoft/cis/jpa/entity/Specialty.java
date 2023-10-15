package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "specialties"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "specialties", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.specialty_seq", allocationSize = 1)
public class Specialty extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "value")
	private String value;

	@Column(name = "default_procedure")
	private String defaultProcedure;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialty", targetEntity = DoctorSpecialty.class)
	private List<DoctorSpecialty> doctorSpecialties;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "specialty", targetEntity = HealthcareCenterSpecialty.class)
	private List<HealthcareCenterSpecialty> healthcareCenterSpecialties;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDefaultProcedure() {
		return defaultProcedure;
	}

	public void setDefaultProcedure(String defaultProcedure) {
		this.defaultProcedure = defaultProcedure;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<DoctorSpecialty> getDoctorSpecialties() {
		if (doctorSpecialties == null) {
			doctorSpecialties = new ArrayList<>();
		}
		return doctorSpecialties;
	}

	public void setDoctorSpecialties(List<DoctorSpecialty> doctorSpecialties) {
		this.doctorSpecialties = doctorSpecialties;
	}

	public List<HealthcareCenterSpecialty> getHealthcareCenterSpecialties() {
		if (healthcareCenterSpecialties == null) {
			healthcareCenterSpecialties = new ArrayList<>();
		}
		return healthcareCenterSpecialties;
	}

	public void setHealthcareCenterSpecialties(List<HealthcareCenterSpecialty> healthcareCenterSpecialties) {
		this.healthcareCenterSpecialties = healthcareCenterSpecialties;
	}

	/* toString */
	@Override
	public String toString() {
		return "Specialty [id=" + id + ", code=" + code + ", value=" + value + ", defaultProcedure=" + defaultProcedure
				+ ", active=" + active + "]";
	}

}