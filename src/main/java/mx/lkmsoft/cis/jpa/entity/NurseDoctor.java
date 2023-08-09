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
 * Persistent class for entity stored in table "nurse_doctor"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "nurse_doctor", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.nurse_doctor_id_seq", allocationSize = 1)
public class NurseDoctor extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nurse_id", referencedColumnName = "id")
	private Nurse nurse;

	@Column(name = "active")
	private boolean active;

	public NurseDoctor() {
	}

	public NurseDoctor(Nurse nurse, Doctor doctor) {
		this.nurse = nurse;
		this.doctor = doctor;
		this.active = true;
	}

	/* Getters and Setters */
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	/* toString */
	public String toString() {
		var sb = new StringBuilder();
		sb.append("[");
		sb.append(id);
		sb.append("]:");
		sb.append(active);
		return sb.toString();
	}

}