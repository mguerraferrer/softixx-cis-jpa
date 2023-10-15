package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "healthcare_center_specialty"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "healthcare_center_specialties", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.healthcare_center_specialty_seq", allocationSize = 1)
public class HealthcareCenterSpecialty extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "healthcare_center_id", referencedColumnName = "id")
	private HealthcareCenter healthcareCenter;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "specialty_id", referencedColumnName = "id")
	private Specialty specialty;

	@Column(name = "active")
	private boolean active;

	/* Getters and Setters */
	public HealthcareCenter getHealthcareCenter() {
		return healthcareCenter;
	}

	public void setHealthcareCenter(HealthcareCenter healthcareCenter) {
		this.healthcareCenter = healthcareCenter;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
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
		return "HealthcareCenterSpecialty [id=" + id + ", healthcareCenter=" + healthcareCenter.getId() + ", specialty="
				+ specialty.getId() + ", active=" + active + "]";
	}

}