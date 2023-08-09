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
 * Persistent class for entity stored in table "patient"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "patient", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.patient_id_seq", allocationSize = 1)
public class Patient extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blood_type_rh_id", referencedColumnName = "id")
	private BloodTypeRh bloodTypeRh;

	@Column(name = "active")
	private boolean active;

	public Patient() {
	}

	public Patient(Person person) {
		this.person = person;
		this.active = true;
	}

	public Patient(Person person, BloodTypeRh bloodTypeRh) {
		this.person = person;
		this.bloodTypeRh = bloodTypeRh;
		this.active = true;
	}

	/* Getters and Setters */
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public BloodTypeRh getBloodTypeRh() {
		return bloodTypeRh;
	}

	public void setBloodTypeRh(BloodTypeRh bloodTypeRh) {
		this.bloodTypeRh = bloodTypeRh;
	}

	/* toString */
	@Override
	public String toString() {
		long bloodTypeRhId = bloodTypeRh != null ? bloodTypeRh.getId() : null;

		return "Patient [id=" + id + ", person=" + person.getId() + ", bloodTypeRh=" + bloodTypeRhId + ", active="
				+ active + "]";
	}

}