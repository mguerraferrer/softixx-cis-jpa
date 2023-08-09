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
 * Persistent class for entity stored in table "nurse_clinical_entity"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "nurse_clinical_entity", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.nurse_clinical_entity_id_seq", allocationSize = 1)
public class NurseClinicalEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_id", referencedColumnName = "id")
	private ClinicalEntity clinicalEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nurse_id", referencedColumnName = "id")
	private Nurse nurse;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nurseClinicalEntity", targetEntity = NurseDoctorClinicalEntity.class)
	private List<NurseDoctorClinicalEntity> nurseDoctorClinicalEntities;

	public NurseClinicalEntity() {
	}

	public NurseClinicalEntity(Nurse nurse, ClinicalEntity clinicalEntity) {
		this.nurse = nurse;
		this.clinicalEntity = clinicalEntity;
		this.active = true;
	}

	/* Getters and Setters */
	public ClinicalEntity getClinicalEntity() {
		return clinicalEntity;
	}

	public void setClinicalEntity(ClinicalEntity clinicalEntity) {
		this.clinicalEntity = clinicalEntity;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	/* toString */
	@Override
	public String toString() {
		return "NurseClinicalEntity [id=" + id + ", clinicalEntity=" + clinicalEntity + ", nurse=" + nurse + ", active="
				+ active + ", nurseDoctorClinicalEntities=" + nurseDoctorClinicalEntities + "]";
	}

}