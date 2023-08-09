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
 * Persistent class for entity stored in table "marital_status"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "marital_status", schema = "nomenclators")
@SequenceGenerator(name = "default_gen", sequenceName = "nomenclators.marital_status_id_seq", allocationSize = 1)
public class MaritalStatus extends NomenclatorEntity {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "maritalStatus", targetEntity = Person.class)
	private List<Person> persons;
	
	/* Getters and Setters */
	public List<Person> getPersons() {
		if (persons == null) {
			persons = new ArrayList<>();
		}
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	/* toString */
	@Override
	public String toString() {
		return "MaritalStatus [id=" + id + ", code=" + code + ", value=" + value + ", active=" + active + "]";
	}

}