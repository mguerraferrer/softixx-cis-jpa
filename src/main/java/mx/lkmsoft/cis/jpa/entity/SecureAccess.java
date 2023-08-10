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
 * Persistent class for entity stored in table "secure_access"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "secure_access", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.secure_access_id_seq", allocationSize = 1)
public class SecureAccess extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "level_access_id", referencedColumnName = "id")
	private AccessLevel accessLevel;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_custom_role_id", referencedColumnName = "id")
	private ClinicalEntityCustomRole clinicalEntityCustomRole;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_entity_system_option_id", referencedColumnName = "id")
	private ClinicalEntitySystemOption clinicalEntitySystemOption;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "private_practice_custom_role_id", referencedColumnName = "id")
	private PrivatePracticeCustomRole privatePracticeCustomRole;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "private_practice_system_option_id", referencedColumnName = "id")
	private PrivatePracticeSystemOption privatePracticeSystemOption;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Column(name = "access")
	private boolean access;

	@Column(name = "active")
	private boolean active;

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

	public ClinicalEntityCustomRole getClinicalEntityCustomRole() {
		return clinicalEntityCustomRole;
	}

	public void setClinicalEntityCustomRole(ClinicalEntityCustomRole clinicalEntityCustomRole) {
		this.clinicalEntityCustomRole = clinicalEntityCustomRole;
	}

	public ClinicalEntitySystemOption getClinicalEntitySystemOption() {
		return clinicalEntitySystemOption;
	}

	public void setClinicalEntitySystemOption(ClinicalEntitySystemOption clinicalEntitySystemOption) {
		this.clinicalEntitySystemOption = clinicalEntitySystemOption;
	}

	public PrivatePracticeCustomRole getPrivatePracticeCustomRole() {
		return privatePracticeCustomRole;
	}

	public void setPrivatePracticeCustomRole(PrivatePracticeCustomRole privatePracticeCustomRole) {
		this.privatePracticeCustomRole = privatePracticeCustomRole;
	}

	public PrivatePracticeSystemOption getPrivatePracticeSystemOption() {
		return privatePracticeSystemOption;
	}

	public void setPrivatePracticeSystemOption(PrivatePracticeSystemOption privatePracticeSystemOption) {
		this.privatePracticeSystemOption = privatePracticeSystemOption;
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
		long cecrId = clinicalEntityCustomRole != null ? clinicalEntityCustomRole.getId() : null;
		long cesoId = clinicalEntitySystemOption != null ? clinicalEntitySystemOption.getId() : null;
		long ppcrId = privatePracticeCustomRole != null ? privatePracticeCustomRole.getId() : null;
		long ppsoId = privatePracticeSystemOption != null ? privatePracticeSystemOption.getId() : null;

		return "SecureAccess [id=" + id + ", accessLevel=" + accessLevel.getId() + ", role=" + role
				+ ", clinicalEntityCustomRole=" + cecrId + ", clinicalEntitySystemOption=" + cesoId
				+ ", privatePracticeCustomRole=" + ppcrId + ", privatePracticeSystemOption=" + ppsoId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", access=" + access + ", active=" + active + "]";
	}

}