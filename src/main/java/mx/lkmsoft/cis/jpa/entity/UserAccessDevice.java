package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.DeviceType;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "user_access_device"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_access_device", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.user_access_device_seq", allocationSize = 1)
@Getter
@Setter
public class UserAccessDevice extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Column(name = "device_type")
	@Enumerated(EnumType.STRING)
	private DeviceType deviceType;

	@Column(name = "details")
	private String details;

	@Column(name = "location")
	private String location;

	@Column(name = "last_access")
	private LocalDateTime lastAccess;

	public UserAccessDevice() {
	}

	public UserAccessDevice(User user, DeviceType deviceType, String details, String location) {
		this.user = user;
		this.deviceType = deviceType;
		this.details = details;
		this.location = location;
		this.lastAccess = LocalDateTime.now();
	}

	/* toString */
	@Override
	public String toString() {
		return "UserAccessDevice [id=" + id + ", user=" + user.getId() + ", deviceType=" + deviceType
				+ ", details=" + details + ", location=" + location + ", lastAccess=" + lastAccess + "]";
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
		UserAccessDevice that = (UserAccessDevice) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}