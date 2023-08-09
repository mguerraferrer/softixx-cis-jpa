package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

@Entity
@Table(name = "roles", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.role_seq_id", allocationSize = 1)
public class Role extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "value")
	private String value;

	@Column(name = "visible")
	private boolean visible;

	@Column(name = "active")
	private boolean active;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role", targetEntity = RoleAccess.class)
	private List<RoleAccess> roleAccesses;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role", targetEntity = SecureAccess.class)
	private List<SecureAccess> secureAccesses;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public List<SecureAccess> getSecureAccesses() {
		if (secureAccesses == null) {
			secureAccesses = new ArrayList<>();
		}
		return secureAccesses;
	}

	public void setSecureAccesses(List<SecureAccess> secureAccesses) {
		this.secureAccesses = secureAccesses;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", code=" + code + ", name=" + name + ", value=" + value + ", visible=" + visible
				+ ", active=" + active + "]";
	}

}