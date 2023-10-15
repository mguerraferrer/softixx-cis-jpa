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
 * Persistent class for entity stored in table "state"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "state", schema = "address")
@SequenceGenerator(name = "default_gen", sequenceName = "address.state_seq", allocationSize = 1)
public class State extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id", referencedColumnName = "id")
	private Country country;

	@Column(name = "value")
	private String value;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state", targetEntity = City.class)
	private List<City> cities;

	/* Getters and Setters */
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

	public List<City> getCities() {
		if (cities == null) {
			cities = new ArrayList<>();
		}
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	/* toString */
	@Override
	public String toString() {
		return "State [id=" + id + ", country=" + country.getId() + " value=" + value + ", active=" + active + "]";
	}

}