package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Persistent class for entity stored in table "master_account"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "master_account", schema = "security")
public class MasterAccount {

	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "healthcare_center_id", referencedColumnName = "id")
	private HealthcareCenter healthcareCenter;

	@Column(name = "active")
	private boolean active;

	public MasterAccount() {
	}

	public MasterAccount(User user, HealthcareCenter healthcareCenter) {
		this.user = user;
		this.healthcareCenter = healthcareCenter;
		this.active = true;
	}

	/* Getters and Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HealthcareCenter getHealthcareCenter() {
		return healthcareCenter;
	}

	public void setHealthcareCenter(HealthcareCenter healthcareCenter) {
		this.healthcareCenter = healthcareCenter;
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
		return "MasterAccount [id=" + id + ", user=" + user + ", healthcareCenter=" + healthcareCenter + ", active="
				+ active + "]";
	}

}