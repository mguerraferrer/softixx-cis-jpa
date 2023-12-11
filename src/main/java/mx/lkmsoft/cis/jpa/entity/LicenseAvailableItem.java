package mx.lkmsoft.cis.jpa.entity;

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

import java.util.Objects;

/**
 * Persistent class for entity stored in table "license_available_item"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license_available_item", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_available_item_seq", allocationSize = 1)
@Getter
@Setter
public class LicenseAvailableItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "license_id", referencedColumnName = "id")
    private License license;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "available_item_id", referencedColumnName = "id")
    private AvailableItem availableItem;
    
    @Column(name = "active")
    private boolean active;

	/* toString */
	@Override
	public String toString() {
		return "LicenseAvailableItem [id=" + id + ", license=" + license + ", availableItem=" + availableItem + ", active="
				+ active + "]";
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
		LicenseAvailableItem that = (LicenseAvailableItem) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}