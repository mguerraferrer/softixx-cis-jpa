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
 * Persistent class for entity stored in table
 * "doctor_clinical_entity_specialties"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "doctor_clinical_entity_specialties", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.doctor_clinical_entity_specialty_id_seq", allocationSize = 1)
public class DoctorClinicalEntitySpecialty extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_clinical_entity_id", referencedColumnName = "id")
	private DoctorClinicalEntity doctorClinicalEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_specialty_id", referencedColumnName = "id")
	private DoctorSpecialty doctorSpecialty;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorClinicalEntitySpecialty", targetEntity = DoctorClinicalEntityConsultationProcedure.class)
	private List<DoctorClinicalEntityConsultationProcedure> doctorClinicalEntityConsultationProcedures;

	public DoctorClinicalEntitySpecialty() {
	}

	public DoctorClinicalEntitySpecialty(DoctorClinicalEntity doctorClinicalEntity, DoctorSpecialty doctorSpecialty) {
		this.doctorClinicalEntity = doctorClinicalEntity;
		this.doctorSpecialty = doctorSpecialty;
		this.active = true;
	}

	/* Getters and Setters */
	public DoctorClinicalEntity getDoctorClinicalEntity() {
		return doctorClinicalEntity;
	}

	public void setDoctorClinicalEntity(DoctorClinicalEntity doctorClinicalEntity) {
		this.doctorClinicalEntity = doctorClinicalEntity;
	}

	public DoctorSpecialty getDoctorSpecialty() {
		return doctorSpecialty;
	}

	public void setDoctorSpecialty(DoctorSpecialty doctorSpecialty) {
		this.doctorSpecialty = doctorSpecialty;
	}

	public List<DoctorClinicalEntityConsultationProcedure> getDoctorClinicalEntityConsultationProcedures() {
		if (doctorClinicalEntityConsultationProcedures == null) {
			doctorClinicalEntityConsultationProcedures = new ArrayList<>();
		}
		return doctorClinicalEntityConsultationProcedures;
	}

	public void setDoctorClinicalEntityConsultationProcedures(
			List<DoctorClinicalEntityConsultationProcedure> doctorClinicalEntityConsultationProcedures) {
		this.doctorClinicalEntityConsultationProcedures = doctorClinicalEntityConsultationProcedures;
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
		return "DoctorClinicalEntitySpecialty [id=" + id + ", doctorSpecialty=" + doctorSpecialty.getId()
				+ ", doctorClinicalEntity=" + doctorClinicalEntity.getId() + ", active=" + active + "]";
	}

}