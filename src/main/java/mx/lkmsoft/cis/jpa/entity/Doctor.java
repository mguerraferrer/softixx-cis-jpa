package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

	@OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL)
	private UserProfile userProfile;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = DoctorSpecialty.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DoctorSpecialty> doctorSpecialties;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = NurseDoctor.class)
	private List<NurseDoctor> nurseDoctors;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = AssistantDoctor.class)
	private List<AssistantDoctor> assistantDoctors;
	
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

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
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

	/* toString */
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", professionalLicense=" + professionalLicense + ", active=" + active + "]";
	}

}