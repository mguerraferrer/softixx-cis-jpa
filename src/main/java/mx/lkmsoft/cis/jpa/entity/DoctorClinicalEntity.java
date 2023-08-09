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
 * Persistent class for entity stored in table "doctor_clinical_entity"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "doctor_clinical_entity", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.doctor_clinical_entity_id_seq", allocationSize = 1)
public class DoctorClinicalEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
	private ClinicalEntity clinicalEntity;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorClinicalEntity", targetEntity = AssistantDoctorClinicalEntity.class)
	private List<AssistantDoctorClinicalEntity> assistantDoctorClinicalEntities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorClinicalEntity", targetEntity = DoctorClinicalEntitySpecialty.class)
	private List<DoctorClinicalEntitySpecialty> doctorClinicalEntitySpecialties;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorClinicalEntity", targetEntity = NurseDoctorClinicalEntity.class)
	private List<NurseDoctorClinicalEntity> nurseDoctorClinicalEntities;

	/* Getters and Setters */
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

	public List<DoctorClinicalEntitySpecialty> getDoctorClinicalEntitySpecialties() {
		if (doctorClinicalEntitySpecialties == null) {
			doctorClinicalEntitySpecialties = new ArrayList<>();
		}
		return doctorClinicalEntitySpecialties;
	}

	public void setDoctorClinicalEntitySpecialties(
			List<DoctorClinicalEntitySpecialty> doctorClinicalEntitySpecialties) {
		this.doctorClinicalEntitySpecialties = doctorClinicalEntitySpecialties;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<NurseDoctorClinicalEntity> getNurseDoctorClinicalEntities() {
		if (nurseDoctorClinicalEntities == null) {
			nurseDoctorClinicalEntities = new ArrayList<>();
		}
		return nurseDoctorClinicalEntities;
	}

	public void setNurseDoctorClinicalEntities(List<NurseDoctorClinicalEntity> nurseDoctorClinicalEntities) {
		this.nurseDoctorClinicalEntities = nurseDoctorClinicalEntities;
	}

	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	/* toString */
	@Override
	public String toString() {
		return "DoctorClinicalEntity [id=" + id + ", doctor=" + doctor.getId() + ", clinicalEntity="
				+ clinicalEntity.getId() + ", active=" + active + "]";
	}

}