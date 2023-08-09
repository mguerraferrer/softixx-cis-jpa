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
 * Persistent class for entity stored in table "assistant_clinical_entity"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "assistant_clinical_entity", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.assistant_clinical_entity_id_seq", allocationSize = 1)
public class AssistantClinicalEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assistant_id", referencedColumnName = "id")
	private Assistant assistant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
	private ClinicalEntity clinicalEntity;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "assistantClinicalEntity", targetEntity = AssistantDoctorClinicalEntity.class)
	private List<AssistantDoctorClinicalEntity> assistantDoctorClinicalEntities;

	public AssistantClinicalEntity() {
	}

	public AssistantClinicalEntity(Assistant assistant, ClinicalEntity clinicalEntity) {
		this.assistant = assistant;
		this.clinicalEntity = clinicalEntity;
		this.active = true;
	}

	/* Getters and Setters */
	public Assistant getAssistant() {
		return assistant;
	}

	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
	}

	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<AssistantDoctorClinicalEntity> getAssistantDoctorClinicalEntities() {
		if (assistantDoctorClinicalEntities == null) {
			assistantDoctorClinicalEntities = new ArrayList<>();
		}
		return assistantDoctorClinicalEntities;
	}

	public void setAssistantDoctorClinicalEntities(
			List<AssistantDoctorClinicalEntity> assistantDoctorClinicalEntities) {
		this.assistantDoctorClinicalEntities = assistantDoctorClinicalEntities;
	}

	/* toString */
	@Override
	public String toString() {
		return "AssistantClinicalEntity [id=" + id + ", assistant=" + assistant.getId() + ", clinicalEntity="
				+ clinicalEntity.getId() + ", active=" + active + "]";
	}

}