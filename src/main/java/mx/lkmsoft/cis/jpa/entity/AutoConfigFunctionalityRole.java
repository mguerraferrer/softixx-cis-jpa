package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "auto_config_functionality_role"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "auto_config_functionality_role", schema = "config")
@SequenceGenerator(name = "default_gen", sequenceName = "config.auto_config_functionality_role_id_seq", allocationSize = 1)
public class AutoConfigFunctionalityRole extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "functionality_id", referencedColumnName = "id")
	private Functionality functionality;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "access_level_id", referencedColumnName = "id")
	private AccessLevel accessLevel;

	@Column(name = "active")
	private boolean active;

	public AutoConfigFunctionalityRole() {
	}

	public AutoConfigFunctionalityRole(Functionality functionality, Role role, AccessLevel accessLevel) {
		this.functionality = functionality;
		this.role = role;
		this.accessLevel = accessLevel;
		this.active = true;
	}

	/* Getters and Setters */
	public Functionality getFunctionality() {
		return functionality;
	}

	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
		return "AutoConfigFunctionalityRole [id=" + id + ", role=" + role.getId() + ", functionality="
				+ functionality.getId() + ", accessLevel=" + accessLevel.getId() + ", active=" + active + "]";
	}

}