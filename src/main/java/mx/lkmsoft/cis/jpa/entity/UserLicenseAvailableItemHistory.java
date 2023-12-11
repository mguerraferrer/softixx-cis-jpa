package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "user_license_available_item_history"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "user_license_available_item_history", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.user_license_available_item_history_seq", allocationSize = 1)
@Getter
@Setter
public class UserLicenseAvailableItemHistory extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_license_service_id", referencedColumnName = "id")
	private UserLicenseAvailableItem userLicenseAvailableItem;

	@Column(name = "entry_date")
	private LocalDateTime entryDate;

	@Column(name = "end_date")
	private LocalDateTime endDate;

	/* toString */
	@Override
	public String toString() {
		return "UserLicenseAvailableItemHistory [id=" + id + ", userLicenseAvailableItem="
				+ userLicenseAvailableItem.getId() + ", entryDate=" + entryDate + ", endDate=" + endDate + "]";
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
		UserLicenseAvailableItemHistory that = (UserLicenseAvailableItemHistory) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}