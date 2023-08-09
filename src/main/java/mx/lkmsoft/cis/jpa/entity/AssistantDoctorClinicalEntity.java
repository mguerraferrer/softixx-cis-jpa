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
 * Persistent class for entity stored in table "assistant_clinical_entity"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "assistant_doctor_clinical_entity", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.assistant_doctor_clinical_entity_id_seq", allocationSize = 1)
public class AssistantDoctorClinicalEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assistant_clinical_entity_id", referencedColumnName = "id")
	private AssistantClinicalEntity assistantClinicalEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_clinical_entity_id", referencedColumnName = "id")
	private DoctorClinicalEntity doctorClinicalEntity;

	@Column(name = "active")
	private boolean active;

	public AssistantDoctorClinicalEntity() {
	}

	public AssistantDoctorClinicalEntity(AssistantClinicalEntity assistantClinicalEntity,
			DoctorClinicalEntity doctorClinicalEntity) {
		this.assistantClinicalEntity = assistantClinicalEntity;
		this.doctorClinicalEntity = doctorClinicalEntity;
		this.active = true;
	}

	/* Getters and Setters */
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public AssistantClinicalEntity getAssistantClinicalEntity() {
		return assistantClinicalEntity;
	}

	public void setAssistantClinicalEntity(AssistantClinicalEntity assistantClinicalEntity) {
		this.assistantClinicalEntity = assistantClinicalEntity;
	}

	public DoctorClinicalEntity getDoctorClinicalEntity() {
		return doctorClinicalEntity;
	}

	public void setDoctorClinicalEntity(DoctorClinicalEntity doctorClinicalEntity) {
		this.doctorClinicalEntity = doctorClinicalEntity;
	}

	/* toString */
	@Override
	public String toString() {
		return "AssistantDoctorClinicalEntity [id=" + id + ", assistantClinicalEntity="
				+ assistantClinicalEntity.getId() + ", doctorClinicalEntity=" + doctorClinicalEntity.getId()
				+ ", active=" + active + "]";
	}

}