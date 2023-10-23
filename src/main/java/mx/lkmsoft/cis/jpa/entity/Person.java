package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableContact;
import mx.lkmsoft.cis.jpa.enumtype.Gender;

/**
 * Persistent class for entity stored in table "person"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "person", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.person_seq", allocationSize = 1)
public class Person extends BaseEntity {

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

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "photo")
	private String photo;

	@Column(name = "mobile1")
	@Convert(converter = AttributeEncryptor.class)
	private String mobile1;

	@Column(name = "mobile2")
	@Convert(converter = AttributeEncryptor.class)
	private String mobile2;

	@Column(name = "mobile3")
	@Convert(converter = AttributeEncryptor.class)
	private String mobile3;

	@Embedded
	protected EmbeddableContact contact;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", targetEntity = PersonAddress.class)
	private List<PersonAddress> addresses;

	public Person() {
	}

	public Person(String name, String paternalSurname, String maternalSurname, Gender gender) {
		this.name = name;
		this.paternalSurname = paternalSurname != null ? paternalSurname.trim() : "";
		this.maternalSurname = maternalSurname != null ? maternalSurname.trim() : "";
		this.identity = identity(this.name, this.paternalSurname, this.maternalSurname);
		this.gender = gender;
	}

	private String identity(final String name, final String paternalSurname, final String maternalSurname) {
		return String.format("%s %s %s", name.trim(), paternalSurname.trim(), maternalSurname.trim());
	}

	/* Getters and Setters */
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getMobile3() {
		return mobile3;
	}

	public void setMobile3(String mobile3) {
		this.mobile3 = mobile3;
	}

	public EmbeddableContact getContact() {
		return contact;
	}

	public void setContact(EmbeddableContact contact) {
		this.contact = contact;
	}
	
	public List<PersonAddress> getAddresses() {
		if (addresses == null) {
			addresses = new ArrayList<>();
		}
		return addresses;
	}

	public void setAddresses(List<PersonAddress> addresses) {
		this.addresses = addresses;
	}

	/* toString */
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", paternalSurname=" + paternalSurname + ", maternalSurname="
				+ maternalSurname + ", identity=" + identity + ", gender=" + gender + ", photo=" + photo + ", mobile1="
				+ mobile1 + ", mobile2=" + mobile2 + ", mobile3=" + mobile3 + ", contact=" + contact + "]";
	}

}