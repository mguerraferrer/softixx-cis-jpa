package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.NomenclatorEntity;

/**
 * Persistent class for entity stored in table "access_level"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "access_level", schema = "nomenclators")
@SequenceGenerator(name = "default_gen", sequenceName = "nomenclators.access_level_id_seq", allocationSize = 1)
public class AccessLevel extends NomenclatorEntity {

	@Column(name = "hierarchy")
	private Integer hierarchy;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accessLevel", targetEntity = UserAccess.class)
	private List<UserAccess> userAccesses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accessLevel", targetEntity = RoleAccess.class)
	private List<RoleAccess> roleAccesses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accessLevel", targetEntity = AutoConfigFunctionalityRole.class)
	private List<AutoConfigFunctionalityRole> autoConfigFunctionalityRoles;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accessLevel", targetEntity = SecureAccess.class)
	private List<SecureAccess> secureAccesses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accessLevel", targetEntity = UserAction.class)
	private List<UserAction> userActions;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accessLevel", targetEntity = ClinicalEntityAccessInfo.class)
	private List<ClinicalEntityAccessInfo> clinicalEntityAccessInfos;

	/* Getters and Setters */
	public Integer getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(Integer hierarchy) {
		this.hierarchy = hierarchy;
	}

	public List<UserAccess> getUserAccesses() {
		if (userAccesses == null) {
			userAccesses = new ArrayList<>();
		}
		return userAccesses;
	}

	public void setUserAccesses(List<UserAccess> userAccesses) {
		this.userAccesses = userAccesses;
	}

	public List<RoleAccess> getRoleAccesses() {
		if (roleAccesses == null) {
			roleAccesses = new ArrayList<>();
		}
		return roleAccesses;
	}

	public void setRoleAccesses(List<RoleAccess> roleAccesses) {
		this.roleAccesses = roleAccesses;
	}

	public List<AutoConfigFunctionalityRole> getAutoconfigFunctionalityRoles() {
		if (autoConfigFunctionalityRoles == null) {
			autoConfigFunctionalityRoles = new ArrayList<>();
		}
		return autoConfigFunctionalityRoles;
	}

	public void setAutoconfigFunctionalityRoles(List<AutoConfigFunctionalityRole> autoConfigFunctionalityRoles) {
		this.autoConfigFunctionalityRoles = autoConfigFunctionalityRoles;
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

	public List<UserAction> getUserActions() {
		if (userActions == null) {
			userActions = new ArrayList<>();
		}
		return userActions;
	}

	public void setUserActions(List<UserAction> userActions) {
		this.userActions = userActions;
	}
	
	public List<ClinicalEntityAccessInfo> getClinicalEntityAccessInfos() {
		if (clinicalEntityAccessInfos == null) {
			clinicalEntityAccessInfos = new ArrayList<>();
		}
		return clinicalEntityAccessInfos;
	}

	public void setClinicalEntityAccessInfos(List<ClinicalEntityAccessInfo> clinicalEntityAccessInfos) {
		this.clinicalEntityAccessInfos = clinicalEntityAccessInfos;
	}

	/* toString */
	@Override
	public String toString() {
		return "AccessLevel [id=" + id + ", code=" + code + ", value=" + value + ", hierarchy=" + hierarchy
				+ ", active=" + active + "]";
	}

}