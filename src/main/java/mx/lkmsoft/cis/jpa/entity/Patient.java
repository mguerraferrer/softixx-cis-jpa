package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.val;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableIdentification;
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
public class Patient {

	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private Person person;

	@Column(name = "dob")
	private LocalDate dob;

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

	@ManyToOne
	@JoinColumn(name = "country_id", referencedColumnName = "id")
	private Country country;

	@Embedded
	private EmbeddableIdentification identification;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient", targetEntity = Appointment.class)
	private List<Appointment> appointments;

	/* Getters and Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public EmbeddableIdentification getIdentification() {
		return identification;
	}

	public void setIdentification(EmbeddableIdentification identification) {
		this.identification = identification;
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
		val countryId = country != null ? country.getId() : null;
		return "Patient [id=" + id + ", person=" + person.getId() + ", dob=" + dob + ", bloodTypeRh=" + bloodTypeRh
				+ ", race=" + race + ", academicStatus=" + academicStatus + ", maritalStatus=" + maritalStatus
				+ ", occupation=" + occupation + ", religion=" + religion + ", country=" + countryId
				+ ", identification=" + identification + ", appointments=" + appointments + "]";
	}

}