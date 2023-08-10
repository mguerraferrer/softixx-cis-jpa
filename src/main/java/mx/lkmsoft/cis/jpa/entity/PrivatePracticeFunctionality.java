package mx.lkmsoft.cis.jpa.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "private_practice_functionality"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "private_practice_functionality", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.private_practice_functionality_id_seq", allocationSize = 1)
public class PrivatePracticeFunctionality extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "private_practice_id", referencedColumnName = "id")
	private PrivatePractice privatePractice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "functionality_id", referencedColumnName = "id")
	private Functionality functionality;

	@Column(name = "hash")
	private String hash;

	@Column(name = "active")
	private boolean active;
	
	public PrivatePracticeFunctionality() {
	}

	public PrivatePracticeFunctionality(PrivatePractice privatePractice, Functionality functionality) {
		this.privatePractice = privatePractice;
		this.functionality = functionality;
		this.hash = UUID.randomUUID().toString().replace("-", "");
		this.active = true;
	}

	/* Getters and Setters */
	public PrivatePractice getPrivatePractice() {
		return privatePractice;
	}

	public void setPrivatePractice(PrivatePractice privatePractice) {
		this.privatePractice = privatePractice;
	}

	public Functionality getFunctionality() {
		return functionality;
	}

	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
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
		return "PrivatePracticeFunctionality [id=" + id + ", privatePractice=" + privatePractice.getId()
				+ ", functionality=" + functionality.getId() + ", hash=" + hash + ", active=" + active + "]";
	}

}