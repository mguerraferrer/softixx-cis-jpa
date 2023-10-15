package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.NomenclatorEntity;

/**
 * Persistent class for entity stored in table "country"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "country", schema = "nomenclators")
@SequenceGenerator(name = "default_gen", sequenceName = "nomenclators.country_seq", allocationSize = 1)
public class Country extends NomenclatorEntity {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country", targetEntity = State.class)
	private List<State> states;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country", targetEntity = Patient.class)
	private List<Patient> patients;

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
	
	public List<Patient> getPatients() {
		if (patients == null) {
			patients = new ArrayList<>();
		}
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	/* toString */
	@Override
	public String toString() {
		return "Country [id=" + id + ", code=" + code + ", value=" + value + ", active=" + active + ", states=" + states
				+ "]";
	}

}