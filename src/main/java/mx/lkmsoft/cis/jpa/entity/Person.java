package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.val;
import mx.lkmsoft.cis.common.data.StringUtils;
import mx.lkmsoft.cis.jpa.base.AuditableEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableContact;
import mx.lkmsoft.cis.jpa.enumtype.Gender;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Persistent class for entity stored in table "person"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "person", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.person_seq", allocationSize = 1)
@Getter
@Setter
public class Person extends AuditableEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "paternal_surname")
	private String paternalSurname;

	@Column(name = "maternal_surname")
	private String maternalSurname;

	@Column(name = "identity")
	private String identity;

	@Column(name = "dob")
	private LocalDate dob;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "photo")
	private String photo;

	@ManyToOne
	@JoinColumn(name = "country_id", referencedColumnName = "id")
	private Country country;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "rfc")
	@Convert(converter = AttributeEncryptor.class)
	private String rfc;

	@Column(name = "curp")
	@Convert(converter = AttributeEncryptor.class)
	private String curp;

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

	@Version
	private Long version;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person", targetEntity = PersonAddress.class)
	@Getter(AccessLevel.NONE)
	private List<PersonAddress> addresses;

	public Person() {
	}

	public Person(String name, String paternalSurname, String maternalSurname, Gender gender, LocalDate dob,
				  Country country, String nationality) {
		this.name = name;
		this.paternalSurname = paternalSurname != null ? paternalSurname.trim() : "";
		this.maternalSurname = maternalSurname != null ? maternalSurname.trim() : "";
		this.identity = identity(this.name, this.paternalSurname, this.maternalSurname);
		this.gender = gender;
		this.dob = dob;
		this.country = country;
		this.nationality = nationality;
	}

	public void identity() {
		this.identity = String.format("%s %s %s", this.name.trim(), this.paternalSurname.trim(), this.maternalSurname.trim());
	}

	private String identity(final String name, final String paternalSurname, final String maternalSurname) {
		return String.format("%s %s %s", name.trim(), paternalSurname.trim(), maternalSurname.trim());
	}

	public List<PersonAddress> getAddresses() {
		if (addresses == null) {
			addresses = new ArrayList<>();
		}
		return addresses;
	}

	public String getMobiles() {
		if (StringUtils.hasValue(mobile1)) {
			var mobileBuilder = new StringBuilder(mobile1);
			if (StringUtils.hasValue(mobile2)) {
				mobileBuilder.append(", ").append(mobile2);
			}
			if (StringUtils.hasValue(mobile3)) {
				mobileBuilder.append(", ").append(mobile3);
			}
			return mobileBuilder.toString();
		}
		return null;
	}

	public String getPhones() {
		if (this.contact != null && StringUtils.hasValue(this.contact.getPhone1())) {
			var phoneBuilder = new StringBuilder(this.contact.getPhone1());
			if (StringUtils.hasValue(this.contact.getPhone2())) {
				phoneBuilder.append(", ").append(this.contact.getPhone2());
			}
			if (StringUtils.hasValue(this.contact.getPhone3())) {
				phoneBuilder.append(", ").append(this.contact.getPhone3());
			}
			return phoneBuilder.toString();
		}
		return null;
	}

	public String getEmails() {
		if (this.contact != null && StringUtils.hasValue(this.contact.getEmail1())) {
			var emailBuilder = new StringBuilder(this.contact.getEmail1());
			if (StringUtils.hasValue(this.contact.getEmail2())) {
				emailBuilder.append(", ").append(this.contact.getEmail2());
			}
			if (StringUtils.hasValue(this.contact.getEmail3())) {
				emailBuilder.append(", ").append(this.contact.getEmail3());
			}
			return emailBuilder.toString();
		}
		return null;
	}

	/* toString */
	@Override
	public String toString() {
		val countryId = country != null ? country.getId() : null;
		return "Person [id=" + id + ", name=" + name + ", paternalSurname=" + paternalSurname + ", maternalSurname="
				+ maternalSurname + ", identity=" + identity + ", dob=" + dob + ", gender=" + gender + ", photo=" + photo
				+ ", country= " + countryId + ", nationality=" + nationality + ", rfc= " + rfc + ", curp=" + curp
				+ ", mobile1=" + mobile1 + ", mobile2=" + mobile2 + ", mobile3=" + mobile3
				+ ", contact=" + contact + ", createOn=" + createOn + ", updateOn=" + updateOn + "]";
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
			: o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
			: this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		Person person = (Person) o;
		return getId() != null && Objects.equals(getId(), person.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}