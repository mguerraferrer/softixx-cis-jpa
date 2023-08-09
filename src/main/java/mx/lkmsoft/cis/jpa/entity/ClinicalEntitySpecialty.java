package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "clinical_entity_specialty"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "clinical_entity_specialties", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.clinical_entity_specialty_id_seq", allocationSize = 1)
public class ClinicalEntitySpecialty extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
	private ClinicalEntity clinicalEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "specialty_id", referencedColumnName = "id")
	private Specialty specialty;

	@Column(name = "hash")
	private String hash;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinicalEntitySpecialty", targetEntity = ClinicalEntityConsultationProcedure.class)
	private List<ClinicalEntityConsultationProcedure> clinicalEntityConsultationProcedures;

	/* Getters and Setters */
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	public List<ClinicalEntityConsultationProcedure> getClinicalEntityServices() {
		if (clinicalEntityConsultationProcedures == null) {
			clinicalEntityConsultationProcedures = new ArrayList<>();
		}
		return clinicalEntityConsultationProcedures;
	}

	public void setClinicalEntityServices(List<ClinicalEntityConsultationProcedure> clinicalEntityConsultationProcedures) {
		this.clinicalEntityConsultationProcedures = clinicalEntityConsultationProcedures;
	}

	/* toString */
	@Override
	public String toString() {
		return "ClinicalEntitySpecialty [id=" + id + ", clinicalEntity=" + clinicalEntity.getId() + ", specialty="
				+ specialty.getIcon() + ", hash=" + hash + ", active=" + active + "]";
	}
	
}