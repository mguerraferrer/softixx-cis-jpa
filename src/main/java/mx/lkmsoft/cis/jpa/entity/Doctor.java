package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableSocial;
import mx.lkmsoft.cis.jpa.enumtype.Gender;

import java.util.ArrayList;
import java.util.List;

/**
 * Persistent class for entity stored in table "doctor"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "doctor", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.doctor_seq", allocationSize = 1)
@Getter
@Setter
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

	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(schema = "common", name = "nurse_doctor", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "nurse_id"))
	@Getter(AccessLevel.NONE)
	private List<Nurse> nurses;

	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(schema = "common", name = "assistant_doctor", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "assistant_id"))
	@Getter(AccessLevel.NONE)
	private List<Assistant> assistants;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", targetEntity = MedicalSchedule.class)
	@Getter(AccessLevel.NONE)
	private List<MedicalSchedule> medicalSchedules;

	public Doctor() {
	}

	public Doctor(String professionalLicense) {
		this.professionalLicense = professionalLicense;
		this.active = true;
	}

	public List<DoctorSpecialty> getDoctorSpecialties() {
		if (doctorSpecialties == null) {
			doctorSpecialties = new ArrayList<>();
		}
		return doctorSpecialties;
	}

	public List<Nurse> getNurses() {
		if (nurses == null) {
			nurses = new ArrayList<>();
		}
		return nurses;
	}

	public List<Assistant> getAssistants() {
		if (assistants == null) {
			assistants = new ArrayList<>();
		}
		return assistants;
	}

	public List<MedicalSchedule> getMedicalSchedules() {
		if (medicalSchedules == null) {
			medicalSchedules = new ArrayList<>();
		}
		return medicalSchedules;
	}

	@Transient
	public String getPrefix() {
		if (this.getUserProfile().getPerson().getGender().equals(Gender.FEMALE)) {
			return "doctor.female.prefix";
		} else {
			return "doctor.male.prefix";
		}
	}

	@Transient
	public String getFullPrefixLower() {
		if (this.getUserProfile().getPerson().getGender().equals(Gender.FEMALE)) {
			return "doctor.female.full.prefix.lower";
		} else {
			return "doctor.male.full.prefix.lower";
		}
	}

	@Transient
	public String getFullPrefixUpper() {
		if (this.getUserProfile().getPerson().getGender().equals(Gender.FEMALE)) {
			return "doctor.female.full.prefix.upper";
		} else {
			return "doctor.male.full.prefix.upper";
		}
	}

	/* toString */
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", professionalLicense=" + professionalLicense + ", social=" + social +
				", active=" + active + "]";
	}

}