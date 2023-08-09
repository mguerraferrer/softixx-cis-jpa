package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "colony"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "colony", schema = "address")
@SequenceGenerator(name = "default_gen", sequenceName = "address.colony_id_seq", allocationSize = 1)
public class Colony extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postal_code_id", referencedColumnName = "id")
	private PostalCode postalCode;
	
	@Column(name = "value")
	private String value;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colony", targetEntity = ClinicalEntityAddress.class)
	private List<ClinicalEntityAddress> clinicalEntityAddresses;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colony", targetEntity = PersonAddress.class)
	private List<PersonAddress> personAddresses;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colony", targetEntity = PrivatePracticeAddress.class)
	private List<PrivatePracticeAddress> privatePracticeAddresses;

	/* Getters and Setters */
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<ClinicalEntityAddress> getClinicalEntityAddresses() {
		if (clinicalEntityAddresses == null) {
			clinicalEntityAddresses = new ArrayList<>();
		}
		return clinicalEntityAddresses;
	}

	public void setClinicalEntityAddresses(List<ClinicalEntityAddress> clinicalEntityAddresses) {
		this.clinicalEntityAddresses = clinicalEntityAddresses;
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

	public List<PrivatePracticeAddress> getPrivatePracticeAddresses() {
		if (privatePracticeAddresses == null) {
			privatePracticeAddresses = new ArrayList<>();
		}
		return privatePracticeAddresses;
	}

	public void setPrivatePracticeAddresses(List<PrivatePracticeAddress> privatePracticeAddresses) {
		this.privatePracticeAddresses = privatePracticeAddresses;
	}

	/* toString */
	@Override
	public String toString() {
		return "Colony [id=" + id + ", value=" + value + ", active=" + active + ", city=" + city.getId()
				+ ", postalCode=" + postalCode.getId() + "]";
	}

}