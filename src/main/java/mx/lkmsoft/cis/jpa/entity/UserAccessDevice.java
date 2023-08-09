package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;

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
import mx.lkmsoft.cis.jpa.enumtype.DeviceType;

/**
 * Persistent class for entity stored in table "user_access_device"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_access_device", schema = "security")
@SequenceGenerator(name = "default_gen", sequenceName = "security.user_access_device_id_seq", allocationSize = 1)
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

	/* Getters and Setters */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(LocalDateTime lastAccess) {
		this.lastAccess = lastAccess;
	}

	/* toString */
	@Override
	public String toString() {
		return "UserAccessDevice [id=" + id + ", user=" + user.getId() + ", deviceType=" + deviceType
				+ ", details=" + details + ", location=" + location + ", lastAccess=" + lastAccess + "]";
	}

}