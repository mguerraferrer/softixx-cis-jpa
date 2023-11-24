package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.val;
import mx.lkmsoft.cis.common.data.CodeGeneratorUtils;
import mx.lkmsoft.cis.jpa.base.SingleAuditableEntity;
import mx.lkmsoft.cis.jpa.enumtype.AcademicStatus;
import mx.lkmsoft.cis.jpa.enumtype.BloodTypeRh;
import mx.lkmsoft.cis.jpa.enumtype.MaritalStatus;
import mx.lkmsoft.cis.jpa.enumtype.Race;

/**
 * Persistent class for entity stored in table "patient"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "patient", schema = "common")
public class Patient extends SingleAuditableEntity {

	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private Person person;

	@Column(name = "code")
	protected String code;

	@Column(name = "blood_type_rh")
	@Enumerated(EnumType.STRING)
	private BloodTypeRh bloodTypeRh;

	@Column(name = "race")
	@Enumerated(EnumType.STRING)
	private Race race;

	@Column(name = "academic_status")
	@Enumerated(EnumType.STRING)
	private AcademicStatus academicStatus;

	@Column(name = "marital_status")
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;

	@Column(name = "occupation")
	private String occupation;

	@Column(name = "religion")
	private String religion;

	@Version
	private Long version;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", targetEntity = Appointment.class)
	private List<Appointment> appointments;

    public Patient() {
    }

    public Patient(Person person, BloodTypeRh bloodTypeRh, Race race, AcademicStatus academicStatus,
                   MaritalStatus maritalStatus, String occupation, String religion) {
		this.person = person;
		this.code = CodeGeneratorUtils.asString();
		this.bloodTypeRh = bloodTypeRh;
		this.race = race;
		this.academicStatus = academicStatus;
		this.maritalStatus = maritalStatus;
		this.occupation = occupation;
		this.religion = religion;
	}

    /* Getters and Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public BloodTypeRh getBloodTypeRh() {
		return bloodTypeRh;
	}

	public void setBloodTypeRh(BloodTypeRh bloodTypeRh) {
		this.bloodTypeRh = bloodTypeRh;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public AcademicStatus getAcademicStatus() {
		return academicStatus;
	}

	public void setAcademicStatus(AcademicStatus academicStatus) {
		this.academicStatus = academicStatus;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public List<Appointment> getAppointments() {
		if (appointments == null) {
			appointments = new ArrayList<>();
		}
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	/* toString */
	@Override
	public String toString() {
		return "Patient [id=" + id + ", code=" + code + ", person=" + person.getId() + ", bloodTypeRh=" + bloodTypeRh
				+ ", race=" + race + ", academicStatus=" + academicStatus + ", maritalStatus=" + maritalStatus
				+ ", occupation=" + occupation + ", religion=" + religion + ", createOn=" + createOn
				+ ", updateOn=" + updateOn + "]";
	}

}