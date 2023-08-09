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
 * Persistent class for entity stored in table "gender"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "gender", schema = "nomenclators")
@SequenceGenerator(name = "default_gen", sequenceName = "nomenclators.gender_id_seq", allocationSize = 1)
public class Gender extends NomenclatorEntity {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gender", targetEntity = Person.class)
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
		return "Gender [id=" + id + ", code=" + code + ", value=" + value + ", active=" + active + "]";
	}

}