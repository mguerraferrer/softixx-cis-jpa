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
 * Persistent class for entity stored in table "doctor_specialties"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "doctor_specialties", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.doctor_specialty_id_seq", allocationSize = 1)
public class DoctorSpecialty extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "specialty_id", referencedColumnName = "id")
	private Specialty specialty;

	@Column(name = "professional_license")
	@Convert(converter = AttributeEncryptor.class)
	private String professionalLicense;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorSpecialty", targetEntity = PrivatePracticeConsultationProcedure.class)
	private List<PrivatePracticeConsultationProcedure> privatePracticeConsultationProcedures;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctorSpecialty", targetEntity = DoctorClinicalEntitySpecialty.class)
	private List<DoctorClinicalEntitySpecialty> doctorClinicalEntitySpecialties; 

	public DoctorSpecialty() {
	}

	public DoctorSpecialty(Doctor doctor, Specialty specialty, String professionalLicense) {
		this.doctor = doctor;
		this.specialty = specialty;
		this.professionalLicense = professionalLicense;
		this.active = true;
	}

	/* Getters and Setters */
	public String getProfessionalLicense() {
		return professionalLicense;
	}

	public void setProfessionalLicense(String professionalLicense) {
		this.professionalLicense = professionalLicense;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	public List<PrivatePracticeConsultationProcedure> getPrivatePracticeServices() {
		if (privatePracticeConsultationProcedures == null) {
			privatePracticeConsultationProcedures = new ArrayList<>();
		}
		return privatePracticeConsultationProcedures;
	}

	public void setPrivatePracticeServices(
			List<PrivatePracticeConsultationProcedure> privatePracticeConsultationProcedures) {
		this.privatePracticeConsultationProcedures = privatePracticeConsultationProcedures;
	}

	/* toString */
	@Override
	public String toString() {
		return "DoctorSpecialty [id=" + id + ", doctor=" + doctor.getId() + ", specialty=" + specialty.getId()
				+ ", professionalLicense=" + professionalLicense + ", active=" + active + "]";
	}

}