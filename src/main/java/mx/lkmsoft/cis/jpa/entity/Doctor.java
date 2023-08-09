package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * Persistent class for entity stored in table "doctor"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "doctor", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.doctor_id_seq", allocationSize = 1)
public class Doctor extends BaseEntity {

	@Column(name = "professional_license")
	@Convert(converter = AttributeEncryptor.class)
	private String professionalLicense;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "doctor", targetEntity = DoctorSpecialty.class)
	private List<DoctorSpecialty> doctorSpecialties;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = NurseDoctor.class)
	private List<NurseDoctor> nurseDoctors;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = AssistantDoctor.class)
	private List<AssistantDoctor> assistantDoctors;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = PrivatePractice.class)
	private List<PrivatePractice> privatePractices;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = UserProfile.class)
	private List<UserProfile> userProfiles;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = DoctorClinicalEntity.class)
	private List<DoctorClinicalEntity> doctorClinicalEntities;

	public Doctor() {
	}

	public Doctor(String professionalLicense) {
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

	public List<DoctorSpecialty> getDoctorSpecialties() {
		if (doctorSpecialties == null) {
			doctorSpecialties = new ArrayList<>();
		}
		return doctorSpecialties;
	}

	public void setDoctorSpecialties(List<DoctorSpecialty> doctorSpecialties) {
		this.doctorSpecialties = doctorSpecialties;
	}

	public List<NurseDoctor> getNurseDoctors() {
		if (nurseDoctors == null) {
			nurseDoctors = new ArrayList<>();
		}
		return nurseDoctors;
	}

	public void setNurseDoctors(List<NurseDoctor> nurseDoctors) {
		this.nurseDoctors = nurseDoctors;
	}

	public List<AssistantDoctor> getAssistantDoctors() {
		if (assistantDoctors == null) {
			assistantDoctors = new ArrayList<>();
		}
		return assistantDoctors;
	}

	public void setAssistantDoctors(List<AssistantDoctor> assistantDoctors) {
		this.assistantDoctors = assistantDoctors;
	}

	public List<PrivatePractice> getPrivatePractices() {
		if (privatePractices == null) {
			privatePractices = new ArrayList<>();
		}
		return privatePractices;
	}

	public void setPrivatePractices(List<PrivatePractice> privatePractices) {
		this.privatePractices = privatePractices;
	}

	public List<UserProfile> getUserProfiles() {
		if (userProfiles == null) {
			userProfiles = new ArrayList<>();
		}
		return userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public List<DoctorClinicalEntity> getDoctorClinicalEntities() {
		if (doctorClinicalEntities == null) {
			doctorClinicalEntities = new ArrayList<>();
		}
		return doctorClinicalEntities;
	}

	public void setDoctorClinicalEntities(List<DoctorClinicalEntity> doctorClinicalEntities) {
		this.doctorClinicalEntities = doctorClinicalEntities;
	}

	/* toString */
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", professionalLicense=" + professionalLicense + ", active=" + active + "]";
	}

}