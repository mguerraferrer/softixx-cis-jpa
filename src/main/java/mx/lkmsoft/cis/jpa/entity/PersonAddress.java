package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableAddress;

/**
 * Persistent class for entity stored in table "person_address"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "person_address", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.person_address_id_seq", allocationSize = 1)
public class PersonAddress extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colony_id", referencedColumnName = "id")
	protected Colony colony;

	@Embedded
	private EmbeddableAddress address;

	/* Getters and Setters */
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Colony getColony() {
		return colony;
	}

	public void setColony(Colony colony) {
		this.colony = colony;
	}

	public EmbeddableAddress getAddress() {
		return address;
	}

	public void setAddress(EmbeddableAddress address) {
		this.address = address;
	}

	/* toString */
	@Override
	public String toString() {
		return "PersonAddress [id=" + id + ", person=" + person + ", colony=" + colony.getId() + ", address=" + address
				+ "]";
	}

}