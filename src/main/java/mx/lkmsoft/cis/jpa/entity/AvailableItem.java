package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "available_item"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "available_item", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.available_item_seq", allocationSize = 1)
@Getter
@Setter
public class AvailableItem extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "value")
	private String value;

	@Column(name = "image")
	private String image;

	@Column(name = "frequently_payment")
	private boolean frequentlyPayment;

	@Column(name = "order")
	private Integer order;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Double price;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "availableItem", targetEntity = LicenseAvailableItem.class)
	@Getter(AccessLevel.NONE)
	private List<LicenseAvailableItem> licenseAvailableItems;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "availableItem", targetEntity = UserLicenseAvailableItem.class)
	@Getter(AccessLevel.NONE)
	private List<UserLicenseAvailableItem> userLicenseAvailableItems;

	public List<LicenseAvailableItem> getLicenseAvailableItems() {
		if (licenseAvailableItems == null) {
			licenseAvailableItems = new ArrayList<>();
		}
		return licenseAvailableItems;
	}

	public List<UserLicenseAvailableItem> getUserLicenseAvailableItems() {
		if (userLicenseAvailableItems == null) {
			userLicenseAvailableItems = new ArrayList<>();
		}
		return userLicenseAvailableItems;
	}

	/* toString */
	@Override
	public String toString() {
		return "AvailableItem [id=" + id + ", code=" + code + ", value=" + value + ", image=" + image
				+ ", frequentlyPayment=" + frequentlyPayment + ", order=" + order + ", description="
				+ description + ", price=" + price + ", active=" + active + "]";
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
		AvailableItem that = (AvailableItem) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
				? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
				: getClass().hashCode();
	}

}