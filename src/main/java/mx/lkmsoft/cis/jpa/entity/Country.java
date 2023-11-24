package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.*;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Persistent class for entity stored in table "country"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "country", schema = "address")
@SequenceGenerator(name = "default_gen", sequenceName = "address.country_seq", allocationSize = 1)
public class Country extends BaseEntity {

	@Column(name = "value")
	protected String value;

	@Column(name = "active")
	protected boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country", targetEntity = State.class)
	private List<State> states;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country", targetEntity = Person.class)
	private List<Person> persons;

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

	/* Getters and Setters */
	public List<State> getStates() {
		if (states == null) {
			states = new ArrayList<>();
		}
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}
	
	public List<Person> getPersons() {
		if (persons == null) {
			persons = new ArrayList<>();
		}
		return persons;
	}

	public void setPatients(List<Person> persons) {
		this.persons = persons;
	}

	/* toString */
	@Override
	public String toString() {
		return "Country [id=" + id + ", value=" + value + ", active=" + active + ", states=" + states
				+ "]";
	}

}