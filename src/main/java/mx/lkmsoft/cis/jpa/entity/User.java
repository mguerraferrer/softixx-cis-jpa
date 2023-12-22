package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.proxy.HibernateProxy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.AuditableEntity;
import mx.lkmsoft.cis.jpa.enumtype.Role;

@Entity
@Table(name = "users", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.user_seq", allocationSize = 1)
@Getter
@Setter
public class User extends AuditableEntity {

	@Column(name = "email")
	private String email;

	@Column(name = "code")
	private String code;

	@Column(name = "photo")
	private String photo;

	@Column(name = "password")
	private String password;

	@Column(name = "last_access")
	private LocalDateTime lastAccess;

	@Column(name = "first_visit")
	private boolean firstVisit;

	@Column(name = "initial_config_completed")
	private boolean initialConfigCompleted;

	@Column(name = "force_passwd_change")
	private boolean forcePasswdChange;

	@Column(name = "activation_code", length = 128)
	private String activationCode;

	@Column(name = "activation_code_due_date")
	private LocalDateTime activationCodeDueDate;

	@Column(name = "change_passwd_code", length = 128)
	private String changePasswdCode;

	@Column(name = "change_passwd_code_due_date")
	private LocalDateTime changePasswdCodeDueDate;

	@Column(name = "failed_attempts")
	private Integer failedAttempts;

	@Column(name = "blocked_access")
	private boolean blockedAccess;

	@Column(name = "activate_on")
	private LocalDateTime activateOn;

	@Version
	private Long version;

	@Column(name = "active")
	private boolean active;

	@ElementCollection(targetClass = Role.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(schema = "security", name = "users_roles")
	@Getter(AccessLevel.NONE)
	@Column(name = "role")
	private List<Role> roles;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Setter(AccessLevel.NONE)
	private UserProfile userProfile;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Setter(AccessLevel.NONE)
	private UserPreferences userPreferences;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Setter(AccessLevel.NONE)
	private UserLicense userLicense;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private MasterAccount masterAccount;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = HealthcareCenterAccess.class)
	@Getter(AccessLevel.NONE)
	private List<HealthcareCenterAccess> healthcareCenterAccesses;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = UserAccess.class)
	@Getter(AccessLevel.NONE)
	private List<UserAccess> userAccesses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = AuthErrorLog.class)
	@Getter(AccessLevel.NONE)
	private List<AuthErrorLog> authErrorLogs;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = UserAccessDevice.class)
	@Getter(AccessLevel.NONE)
	private List<UserAccessDevice> userAccessDevices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", targetEntity = ErrorLog.class)
	@Getter(AccessLevel.NONE)
	private List<ErrorLog> errorLogs;

	public List<Role> getRoles() {
		if (roles == null) {
			roles = new ArrayList<>();
		}
		return roles;
	}

	@Transient
	public void addRole(Role role) {
		if (this.roles == null) {
			this.roles = new ArrayList<>();
		}
		this.roles.add(role);
	}

	@Transient
	public boolean hasRole(String roleCode) {
		return roles.stream().anyMatch(role -> role.name().equalsIgnoreCase(roleCode));
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
		this.userProfile.setUser(this);
	}

	public void setUserPreferences(UserPreferences userPreferences) {
		this.userPreferences = userPreferences;
		this.userPreferences.setUser(this);
	}

	public void setUserLicense(UserLicense userLicense) {
		this.userLicense = userLicense;
		this.userLicense.setUser(this);
	}

	public List<HealthcareCenterAccess> getHealthcareCenterAccesses() {
		if (healthcareCenterAccesses == null) {
			healthcareCenterAccesses = new ArrayList<>();
		}
		return healthcareCenterAccesses;
	}

	public List<UserAccess> getUserAccesses() {
		if (userAccesses == null) {
			userAccesses = new ArrayList<>();
		}
		return userAccesses;
	}

	public List<AuthErrorLog> getAuthErrorLogs() {
		if (authErrorLogs == null) {
			authErrorLogs = new ArrayList<>();
		}
		return authErrorLogs;
	}

	public List<UserAccessDevice> getUserAccessDevices() {
		if (userAccessDevices == null) {
			userAccessDevices = new ArrayList<>();
		}
		return userAccessDevices;
	}

	public List<ErrorLog> getErrorLogs() {
		if (errorLogs == null) {
			errorLogs = new ArrayList<>();
		}
		return errorLogs;
	}

	/**
	 * Update user data on successful authentication
	 * 
	 */
	@Transient
	public void updateOnSuccessfulAuth() {
		if (this.isFirstVisit()) {
			this.setFirstVisit(false);
		}
		
		this.setFailedAttempts(0);
		this.setBlockedAccess(false);
		this.setLastAccess(LocalDateTime.now());
	}
	
	/**
	 * Update user data on log out
	 * 
	 */
	@Transient
	public void updateOnLogout() {
		this.setLastAccess(LocalDateTime.now());
	}

	/* toString */
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", code=" + code +", photo=" + photo + ", password=" + null + ", roles=" + roles
				+ ", activateOn=" + activateOn + ", lastAccess=" + lastAccess + ", firstVisit=" + firstVisit
				+ ", initialConfigCompleted=" + initialConfigCompleted + ", forcePasswdChange=" + forcePasswdChange
				+ ", activationCode=" + activationCode + ", activationCodeDueDate=" + activationCodeDueDate
				+ ", changePasswdCode=" + changePasswdCode + ", changePasswdCodeDueDate=" + changePasswdCodeDueDate
				+ ", failedAttempts=" + failedAttempts + ", blockedAccess=" + blockedAccess + ", createOon=" + createOn
				+ ", updateOn=" + updateOn + ", version=" + version + ", active=" + active + "]";
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
			: o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
			: this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		User user = (User) o;
		return getId() != null && Objects.equals(getId(), user.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}