package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;
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
 * Persistent class for entity stored in table "person"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "person", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.person_id_seq", allocationSize = 1)
public class Person extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "race_id", referencedColumnName = "id")
	private Race race;

	@ManyToOne
	@JoinColumn(name = "academic_status_id", referencedColumnName = "id")
	private AcademicStatus academicStatus;

	@ManyToOne
	@JoinColumn(name = "marital_status_id", referencedColumnName = "id")
	private MaritalStatus maritalStatus;

	@ManyToOne
	@JoinColumn(name = "gender_id", referencedColumnName = "id")
	private Gender gender;

	@ManyToOne
	@JoinColumn(name = "country_id", referencedColumnName = "id")
	private Country country;

	@Column(name = "name")
	@Convert(converter = AttributeEncryptor.class)
	private String name;

	@Column(name = "paternal_surname")
	@Convert(converter = AttributeEncryptor.class)
	private String paternalSurname;

	@Column(name = "maternal_surname")
	@Convert(converter = AttributeEncryptor.class)
	private String maternalSurname;
	
	@Column(name = "identity")
	@Convert(converter = AttributeEncryptor.class)
	private String identity;

	@Column(name = "dob")
	private LocalDate dob;

	@Column(name = "photo")
	private String photo;

	@Column(name = "rfc")
	@Convert(converter = AttributeEncryptor.class)
	private String rfc;

	@Column(name = "curp")
	@Convert(converter = AttributeEncryptor.class)
	private String curp;

	@Column(name = "occupation")
	private String occupation;

	@Column(name = "religion")
	private String religion;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", targetEntity = PersonAddress.class)
	private List<PersonAddress> personAddresses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", targetEntity = PersonAccess.class)
	private List<PersonAccess> personAccesses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", targetEntity = PersonContactInfo.class)
	private List<PersonContactInfo> personContactInfos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", targetEntity = Patient.class)
	private List<Patient> patients;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", targetEntity = UserProfile.class)
	private List<UserProfile> userProfiles;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", targetEntity = Appointment.class)
	private List<Appointment> appointments;

	public Person() {
	}

	public Person(String name, String paternalSurname, String maternalSurname, Gender gender) {
		this.name = name;
		this.paternalSurname = paternalSurname != null ? paternalSurname.trim() : "";
		this.maternalSurname = maternalSurname != null ? maternalSurname.trim() : "";
		this.identity = identity(this.name, this.paternalSurname, this.maternalSurname);
		this.gender = gender;
		this.rfc = "";
		this.curp = "";
		this.active = true;
	}

	public Person(String name, String paternalSurname, String maternalSurname, Gender gender, LocalDate dob) {
		this.name = name;
		this.paternalSurname = paternalSurname != null ? paternalSurname.trim() : "";
		this.maternalSurname = maternalSurname != null ? maternalSurname.trim() : "";
		this.identity = identity(this.name, this.paternalSurname, this.maternalSurname);
		this.gender = gender;
		this.dob = dob;
		this.rfc = "";
		this.curp = "";
		this.active = true;
	}

	private String identity(final String name, final String paternalSurname, final String maternalSurname) {
		return String.format("%s %s %s", name.trim(), paternalSurname.trim(), maternalSurname.trim());
	}
	
	/* Getters and Setters */
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaternalSurname() {
		return paternalSurname;
	}

	public void setPaternalSurname(String paternalSurname) {
		this.paternalSurname = paternalSurname;
	}

	public String getMaternalSurname() {
		return maternalSurname;
	}

	public void setMaternalSurname(String maternalSurname) {
		this.maternalSurname = maternalSurname;
	}
	
	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<PersonAddress> getPersonAddresses() {
		if (personAddresses == null) {
			personAddresses = new ArrayList<>();
		}
		return personAddresses;
	}

	public void setPersonAddresses(List<PersonAddress> personAddresses) {
		this.personAddresses = personAddresses;
	}

	public void setPersonAccesses(List<PersonAccess> personAccesses) {
		this.personAccesses = personAccesses;
	}

	public List<PersonAccess> getPersonAccesses() {
		if (personAccesses == null) {
			personAccesses = new ArrayList<>();
		}
		return personAccesses;
	}

	public List<PersonContactInfo> getPersonContactInfos() {
		if (personContactInfos == null) {
			personContactInfos = new ArrayList<>();
		}
		return personContactInfos;
	}

	public void setPersonContactInfos(List<PersonContactInfo> personContactInfos) {
		this.personContactInfos = personContactInfos;
	}

	public List<Patient> getPatients() {
		if (patients == null) {
			patients = new ArrayList<>();
		}
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
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
		long raceId = race != null ? race.getId() : null;
		long academicStatusId = academicStatus != null ? academicStatus.getId() : null;
		long maritalStatusId = maritalStatus != null ? maritalStatus.getId() : null;
		long genderId = gender != null ? gender.getId() : null;
		long countryId = country != null ? country.getId() : null;

		return "Person [id=" + id + ", race=" + raceId + ", academicStatus=" + academicStatusId + ", maritalStatus="
				+ maritalStatusId + ", gender=" + genderId + ", country=" + countryId + ", name=" + name
				+ ", paternalSurname=" + paternalSurname + ", maternalSurname=" + maternalSurname + ", identity="
				+ identity + ", dob=" + dob + ", photo=" + photo + ", rfc=" + rfc + ", curp=" + curp + ", occupation="
				+ occupation + ", religion=" + religion + ", active=" + active + "]";
	}

}