package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableAccess;

/**
 * Persistent class for entity stored in table "participant"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "healthcare_center_access", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.healthcare_center_access_seq", allocationSize = 1)
public class HealthcareCenterAccess extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "healthcare_center_id", referencedColumnName = "id")
	private HealthcareCenter healthcareCenter;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Embedded
	private EmbeddableAccess access;
	
	@Column(name = "ip")
	@Convert(converter = AttributeEncryptor.class)
	private String ip;

	@Column(name = "active")
	private boolean active;

	public HealthcareCenterAccess() {
	}

	public HealthcareCenterAccess(HealthcareCenter healthcareCenter, User user) {
		this.healthcareCenter = healthcareCenter;
		this.user = user;
		this.active = true;
	}

	/* Getters and Setters */
	public HealthcareCenter getHealthcareCenter() {
		return healthcareCenter;
	}

	public void setHealthcareCenter(HealthcareCenter healthcareCenter) {
		this.healthcareCenter = healthcareCenter;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EmbeddableAccess getAccess() {
		return access;
	}

	public void setAccess(EmbeddableAccess access) {
		this.access = access;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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
		return "HealthcareCenterAccess [id=" + id + ", healthcareCenter=" + healthcareCenter + ", user=" + user
				+ ", access=" + access + ", ip=" + ip + ", active=" + active + "]";
	}

}