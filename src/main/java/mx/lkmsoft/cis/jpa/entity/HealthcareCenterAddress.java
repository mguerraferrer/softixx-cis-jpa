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
 * Persistent class for entity stored in table "healthcare_center_address"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "healthcare_center_address", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.healthcare_center_address_seq", allocationSize = 1)
public class HealthcareCenterAddress extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "healthcare_center_id", referencedColumnName = "id")
	private HealthcareCenter healthcareCenter;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colony_id", referencedColumnName = "id")
	protected Colony colony;

	@Embedded
	private EmbeddableAddress address;

	/* Getters and Setters */
	public HealthcareCenter getHealthcareCenter() {
		return healthcareCenter;
	}

	public void setHealthcareCenter(HealthcareCenter healthcareCenter) {
		this.healthcareCenter = healthcareCenter;
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
		return "HealthcareCenterAddress [id=" + id + ", healthcareCenter=" + healthcareCenter.getId() + ", colony="
				+ colony.getId() + ", address=" + address + "]";
	}

}