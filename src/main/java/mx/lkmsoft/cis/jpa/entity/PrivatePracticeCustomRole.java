package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

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
 * Persistent class for entity stored in table "private_practice_custom_role"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "private_practice_custom_role", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.private_practice_custom_role_id_seq", allocationSize = 1)
public class PrivatePracticeCustomRole extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "private_practice_id", referencedColumnName = "id")
	private PrivatePractice privatePractice;

	@Column(name = "code")
	private String code;

	@Column(name = "value")
	private String value;

	@Column(name = "active")
	private boolean active;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privatePracticeCustomRole", targetEntity = SecureAccess.class)
	private List<SecureAccess> secureAccesses;

	/* Getters and Setters */
	public PrivatePractice getPrivatePractice() {
		return privatePractice;
	}

	public void setPrivatePractice(PrivatePractice privatePractice) {
		this.privatePractice = privatePractice;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
		return "PrivatePracticeCustomRole [id=" + id + ", privatePractice=" + privatePractice.getId() + ", code=" + code
				+ ", value=" + value + ", active=" + active + "]";
	}

}