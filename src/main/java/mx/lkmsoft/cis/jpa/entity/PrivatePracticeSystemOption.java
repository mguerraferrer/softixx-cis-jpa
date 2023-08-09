package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "private_practice_system_option"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "private_practice_system_option", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.private_practice_system_option_id_seq", allocationSize = 1)
public class PrivatePracticeSystemOption extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "private_practice_id", referencedColumnName = "id")
	private PrivatePractice privatePractice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auto_config_system_option_id", referencedColumnName = "id")
	private AutoConfigSystemOption autoConfigSystemOption;

	@Column(name = "hash")
	private String hash;

	@Column(name = "active")
	private boolean active;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privatePracticeSystemOption", targetEntity = SecureAccess.class)
	private List<SecureAccess> secureAccesses;

	public PrivatePracticeSystemOption() {
	}

	public PrivatePracticeSystemOption(PrivatePractice privatePractice, AutoConfigSystemOption autoConfigSystemOption) {
		this.privatePractice = privatePractice;
		this.autoConfigSystemOption = autoConfigSystemOption;
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

	public AutoConfigSystemOption getAutoConfigSystemOption() {
		return autoConfigSystemOption;
	}

	public void setAutoConfigSystemOption(AutoConfigSystemOption autoConfigSystemOption) {
		this.autoConfigSystemOption = autoConfigSystemOption;
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
	
	public List<SecureAccess> getSecureAccesses() {
		if (secureAccesses == null) {
			secureAccesses = new ArrayList<>();
		}
		return secureAccesses;
	}

	public void setSecureAccesses(List<SecureAccess> secureAccesses) {
		this.secureAccesses = secureAccesses;
	}

	/* toString */
	@Override
	public String toString() {
		return "PrivatePracticeSystemOption [id=" + id + ", privatePractice=" + privatePractice.getId()
				+ ", autoConfigSystemOption=" + autoConfigSystemOption.getId() + ", hash=" + hash + ", active=" + active
				+ "]";
	}

}