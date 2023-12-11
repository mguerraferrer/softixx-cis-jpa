package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.AccessLevel;
import mx.lkmsoft.cis.jpa.enumtype.Role;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "role_access"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "role_access", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.role_access_seq", allocationSize = 1)
@Getter
@Setter
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

	/* toString */
	@Override
	public String toString() {
		return "RoleAccess [id=" + id + ", role=" + role + ", referenceCode=" + referenceCode + ", accessLevel="
				+ accessLevel + ", startTime=" + startTime + ", endTime=" + endTime + "]";
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
		RoleAccess that = (RoleAccess) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}