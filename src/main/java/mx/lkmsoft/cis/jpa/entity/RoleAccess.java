package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.AccessLevel;
import mx.lkmsoft.cis.jpa.enumtype.Role;

/**
 * Persistent class for entity stored in table "role_access"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "role_access", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.role_access_seq", allocationSize = 1)
public class RoleAccess extends BaseEntity {

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(name = "reference_code")
	private String referenceCode;

	@Column(name = "access_level")
	@Enumerated(EnumType.STRING)
	private AccessLevel accessLevel;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	/* Getters and Setters */
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	/* toString */
	@Override
	public String toString() {
		return "RoleAccess [id=" + id + ", role=" + role + ", referenceCode=" + referenceCode + ", accessLevel="
				+ accessLevel + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}