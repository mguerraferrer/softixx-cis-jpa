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
 * Persistent class for entity stored in table "nurse_clinical_entity"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "nurse_doctor_clinical_entity", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.nurse_doctor_clinical_entity_id_seq", allocationSize = 1)
public class NurseDoctorClinicalEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_clinical_entity_id", referencedColumnName = "id")
	private DoctorClinicalEntity doctorClinicalEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nurse_clinical_entity_id", referencedColumnName = "id")
	private NurseClinicalEntity nurseClinicalEntity;

	@Column(name = "active")
	private boolean active;

	public NurseDoctorClinicalEntity() {
	}

	public NurseDoctorClinicalEntity(NurseClinicalEntity nurseClinicalEntity,
			DoctorClinicalEntity doctorClinicalEntity) {
		this.nurseClinicalEntity = nurseClinicalEntity;
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

	public DoctorClinicalEntity getDoctorClinicalEntity() {
		return doctorClinicalEntity;
	}

	public void setDoctorClinicalEntity(DoctorClinicalEntity doctorClinicalEntity) {
		this.doctorClinicalEntity = doctorClinicalEntity;
	}

	public NurseClinicalEntity getNurseClinicalEntity() {
		return nurseClinicalEntity;
	}

	public void setNurseClinicalEntity(NurseClinicalEntity nurseClinicalEntity) {
		this.nurseClinicalEntity = nurseClinicalEntity;
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