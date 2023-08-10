package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.Role;

/**
 * Persistent class for entity stored in table "role_access"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "role_access", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.role_access_id_seq", allocationSize = 1)
public class RoleAccess extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "level_access_id", referencedColumnName = "id")
	private AccessLevel accessLevel;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "private_practice_functionality_id", referencedColumnName = "id")
	private PrivatePracticeFunctionality privatePracticeFunctionality;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_functionality_id", referencedColumnName = "id")
	private ClinicalEntityFunctionality clinicalEntityFunctionality;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Column(name = "access")
	private boolean access;

	@Column(name = "active")
	private boolean active;

	public RoleAccess withPrivatePractice(PrivatePracticeFunctionality privatePracticeFunctionality, Role role,
			AccessLevel accessLevel) {
		this.privatePracticeFunctionality = privatePracticeFunctionality;
		this.role = role;
		this.accessLevel = accessLevel;
		this.access = true;
		this.active = true;
		return this;
	}

	public RoleAccess withClinicalEntity(ClinicalEntityFunctionality clinicalEntityFunctionality, Role role,
			AccessLevel accessLevel) {
		this.clinicalEntityFunctionality = clinicalEntityFunctionality;
		this.role = role;
		this.accessLevel = accessLevel;
		this.access = true;
		this.active = true;
		return this;
	}

	/* Getters and Setters */
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

	public PrivatePracticeFunctionality getPrivatePracticeFunctionality() {
		return privatePracticeFunctionality;
	}

	public void setPrivatePracticeFunctionality(PrivatePracticeFunctionality privatePracticeFunctionality) {
		this.privatePracticeFunctionality = privatePracticeFunctionality;
	}

	public ClinicalEntityFunctionality getClinicalEntityFunctionality() {
		return clinicalEntityFunctionality;
	}

	public void setClinicalEntityFunctionality(ClinicalEntityFunctionality clinicalEntityFunctionality) {
		this.clinicalEntityFunctionality = clinicalEntityFunctionality;
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

	public boolean isAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
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
		long privatePracticeFncId = privatePracticeFunctionality != null ? privatePracticeFunctionality.getId() : null;
		long clinicalEntityFncId = clinicalEntityFunctionality != null ? clinicalEntityFunctionality.getId() : null;

		return "RoleAccess [id=" + id + ", accessLevel=" + accessLevel.getId() + ", role=" + role
				+ ", privatePracticeFunctionality=" + privatePracticeFncId + ", clinicalEntityFunctionality="
				+ clinicalEntityFncId + ", startTime=" + startTime + ", endTime=" + endTime + ", access=" + access
				+ ", active=" + active + "]";
	}

}