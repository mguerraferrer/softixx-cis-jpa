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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colony", targetEntity = HealthcareCenterAddress.class)
	private List<HealthcareCenterAddress> healthcareCenterAddresses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colony", targetEntity = PersonAddress.class)
	private List<PersonAddress> personAddresses;

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

	public List<HealthcareCenterAddress> getHealthcareCenterAddresses() {
		if (healthcareCenterAddresses == null) {
			healthcareCenterAddresses = new ArrayList<>();
		}
		return healthcareCenterAddresses;
	}

	public void setHealthcareCenterAddresses(List<HealthcareCenterAddress> healthcareCenterAddresses) {
		this.healthcareCenterAddresses = healthcareCenterAddresses;
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

	/* toString */
	@Override
	public String toString() {
		return "Colony [id=" + id + ", value=" + value + ", active=" + active + ", city=" + city.getId()
				+ ", postalCode=" + postalCode.getId() + "]";
	}

}