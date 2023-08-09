package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "person_access"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "person_access", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.person_access_id_seq", allocationSize = 1)
public class PersonAccess extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
	private ClinicalEntity clinicalEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "private_practice_id", referencedColumnName = "id")
	private PrivatePractice privatePractice;

	@Column(name = "active")
	private boolean active;

	@Transient
	public PersonAccess withPrivatePractice(Person person, PrivatePractice privatePractice) {
		this.person = person;
		this.privatePractice = privatePractice;
		this.active = true;
		return this;
	}

	@Transient
	public PersonAccess withClinicalEntity(Person person, ClinicalEntity clinicalEntity) {
		this.person = person;
		this.clinicalEntity = clinicalEntity;
		this.active = true;
		return this;
	}

	/* Getters and Setters */
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public PrivatePractice getPrivatePractice() {
		return privatePractice;
	}

	public void setPrivatePractice(PrivatePractice privatePractice) {
		this.privatePractice = privatePractice;
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
		long clinicalEntityId = clinicalEntity != null ? clinicalEntity.getId() : null;
		long privatePracticeId = privatePractice != null ? privatePractice.getId() : null;

		return "PersonAccess [id=" + id + ", person=" + person + ", clinicalEntity=" + clinicalEntityId
				+ ", privatePractice=" + privatePracticeId + ", active=" + active + "]";
	}

}