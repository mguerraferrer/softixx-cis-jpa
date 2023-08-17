package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.enumtype.BloodTypeRh;

/**
 * Persistent class for entity stored in table "patient"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "patient", schema = "common")
public class Patient {

	@Id
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private Person person;

	@Column(name = "blood_type_rh")
	@Enumerated(EnumType.STRING)
	private BloodTypeRh bloodTypeRh;

	public Patient() {
	}

	public Patient(Person person) {
		this.person = person;
	}

	public Patient(Person person, BloodTypeRh bloodTypeRh) {
		this.person = person;
		this.bloodTypeRh = bloodTypeRh;
	}

	/* Getters and Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Patient [id=" + id + ", person=" + person.getId() + ", bloodTypeRh=" + bloodTypeRh.name() + "]";
	}

}