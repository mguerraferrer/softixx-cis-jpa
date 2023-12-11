package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "user_license_available_item"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_license_available_item", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_available_item_seq", allocationSize = 1)
@Getter
@Setter
public class UserLicenseAvailableItem extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "available_item_id", referencedColumnName = "id")
	private AvailableItem availableItem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_id", referencedColumnName = "id")
	private UserLicense userLicense;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userLicenseAvailableItem", targetEntity = UserLicenseAvailableItemHistory.class)
	@Getter(AccessLevel.NONE)
	private List<UserLicenseAvailableItemHistory> userLicenseServiceHistories;

	public List<UserLicenseAvailableItemHistory> getUserLicenseServiceHistories() {
		if (userLicenseServiceHistories == null) {
			userLicenseServiceHistories = new ArrayList<>();
		}
		return userLicenseServiceHistories;
	}

	/* toString */
	@Override
	public String toString() {
		return "UserLicenseAvailableItem [id=" + id + ", availableItem=" + availableItem.getId()
				+ ", userLicense=" + userLicense.getId() + ", active=" + active + "]";
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
		UserLicenseAvailableItem that = (UserLicenseAvailableItem) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}