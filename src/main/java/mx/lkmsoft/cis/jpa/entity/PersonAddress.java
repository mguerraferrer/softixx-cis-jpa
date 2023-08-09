package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

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
	private Colony colony;

	@Column(name = "street")
	@Convert(converter = AttributeEncryptor.class)
	private String street;

	@Column(name = "btw_street")
	@Convert(converter = AttributeEncryptor.class)
	private String btwStreet;

	@Column(name = "outside_number")
	@Convert(converter = AttributeEncryptor.class)
	private String outsideNumber;

	@Column(name = "inside_number")
	@Convert(converter = AttributeEncryptor.class)
	private String insideNumber;

	@Column(name = "reference")
	@Convert(converter = AttributeEncryptor.class)
	private String reference;

	@Column(name = "active")
	private boolean active;

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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBtwStreet() {
		return btwStreet;
	}

	public void setBtwStreet(String btwStreet) {
		this.btwStreet = btwStreet;
	}

	public String getOutsideNumber() {
		return outsideNumber;
	}

	public void setOutsideNumber(String outsideNumber) {
		this.outsideNumber = outsideNumber;
	}

	public String getInsideNumber() {
		return insideNumber;
	}

	public void setInsideNumber(String insideNumber) {
		this.insideNumber = insideNumber;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/* toString */
	@Override
	public String toString() {
		return "PersonAddress [id=" + id + ", person=" + person + ", colony=" + colony.getId() + ", street=" + street
				+ ", btwStreet=" + btwStreet + ", outsideNumber=" + outsideNumber + ", insideNumber=" + insideNumber
				+ ", reference=" + reference + ", active=" + active + "]";
	}

}