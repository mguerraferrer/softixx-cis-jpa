package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

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
	@JoinColumn(name = "specialty_id", referencedColumnName = "id")
	private Specialty specialty;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_clinical_entity_id", referencedColumnName = "id")
	private DoctorClinicalEntity doctorClinicalEntity;

	@Column(name = "professional_license")
	@Convert(converter = AttributeEncryptor.class)
	private String professionalLicense;

	@Column(name = "appointment_duration")
	private Integer appointmentDuration;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorClinicalEntitySpecialty", targetEntity = DoctorClinicalEntityConsultationProcedure.class)
	private List<DoctorClinicalEntityConsultationProcedure> doctorClinicalEntityConsultationProcedures;

	public DoctorClinicalEntitySpecialty() {
	}

	public DoctorClinicalEntitySpecialty(DoctorClinicalEntity doctorClinicalEntity, Specialty specialty,
			String professionalLicense, Integer appointmentDuration) {
		this.doctorClinicalEntity = doctorClinicalEntity;
		this.specialty = specialty;
		this.professionalLicense = professionalLicense;
		this.appointmentDuration = appointmentDuration;
		this.active = true;
	}

	/* Getters and Setters */
	public String getProfessionalLicense() {
		return professionalLicense;
	}

	public void setProfessionalLicense(String professionalLicense) {
		this.professionalLicense = professionalLicense;
	}

	public Integer getAppointmentDuration() {
		return appointmentDuration;
	}

	public void setAppointmentDuration(Integer appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<DoctorClinicalEntityConsultationProcedure> getDoctorClinicalEntityServices() {
		if (doctorClinicalEntityConsultationProcedures == null) {
			doctorClinicalEntityConsultationProcedures = new ArrayList<>();
		}
		return doctorClinicalEntityConsultationProcedures;
	}

	public void setDoctorClinicalEntityServices(List<DoctorClinicalEntityConsultationProcedure> doctorClinicalEntityConsultationProcedures) {
		this.doctorClinicalEntityConsultationProcedures = doctorClinicalEntityConsultationProcedures;
	}

	public DoctorClinicalEntity getDoctorClinicalEntity() {
		return doctorClinicalEntity;
	}

	public void setDoctorClinicalEntity(DoctorClinicalEntity doctorClinicalEntity) {
		this.doctorClinicalEntity = doctorClinicalEntity;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	/* toString */
	@Override
	public String toString() {
		return "DoctorClinicalEntitySpecialty [id=" + id + ", specialty=" + specialty.getId()
				+ ", doctorClinicalEntity=" + doctorClinicalEntity.getId() + ", professionalLicense="
				+ professionalLicense + ", appointmentDuration=" + appointmentDuration + ", active=" + active + "]";
	}

}