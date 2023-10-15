package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableSocial;

/**
 * Persistent class for entity stored in table "doctor"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "doctor", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.doctor_seq", allocationSize = 1)
public class Doctor extends BaseEntity {

	@Column(name = "professional_license")
	@Convert(converter = AttributeEncryptor.class)
	private String professionalLicense;

	@Embedded
	private EmbeddableSocial social;

	@Column(name = "active")
	private boolean active;

	@OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL)
	private UserProfile userProfile;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = DoctorSpecialty.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DoctorSpecialty> doctorSpecialties;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(schema = "common", name = "nurse_doctor", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "nurse_id"))
	private List<Nurse> nurses;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(schema = "common", name = "assistant_doctor", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "assistant_id"))
	private List<Assistant> assistants;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = MedicalSchedule.class)
	private List<MedicalSchedule> medicalSchedules;

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

	public EmbeddableSocial getSocial() {
		return social;
	}

	public void setSocial(EmbeddableSocial social) {
		this.social = social;
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

	public List<Nurse> getNurses() {
		if (nurses == null) {
			nurses = new ArrayList<>();
		}
		return nurses;
	}

	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}

	public List<Assistant> getAssistants() {
		if (assistants == null) {
			assistants = new ArrayList<>();
		}
		return assistants;
	}

	public void setAssistants(List<Assistant> assistants) {
		this.assistants = assistants;
	}

	public List<MedicalSchedule> getMedicalSchedules() {
		if (medicalSchedules == null) {
			medicalSchedules = new ArrayList<>();
		}
		return medicalSchedules;
	}

	public void setMedicalSchedules(List<MedicalSchedule> medicalSchedules) {
		this.medicalSchedules = medicalSchedules;
	}

	/* toString */
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", professionalLicense=" + professionalLicense + ", social=" + social + ", active="
				+ active + "]";
	}

}