package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.enumtype.PaymentMode;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * Persistent class for entity stored in table "license_config"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "license_config", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.license_config_seq", allocationSize = 1)
@Getter
@Setter
public class LicenseConfig extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "license_id", referencedColumnName = "id")
	private License license;

	@Column(name = "payment_mode")
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;

	@Column(name = "discount")
	@Getter(AccessLevel.NONE)
	private Integer discount;

	@Column(name = "active")
	private boolean active;

	public Integer getDiscount() {
		return discount != null ? discount : 0;
	}

	/* toString */
	public String toString() {
		return "LicenseConfig [id=" + id + ", license=" + license.getId() + ", paymentMode=" + paymentMode + ", discount="
				+ discount + ", active=" + active + "]";
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
		LicenseConfig that = (LicenseConfig) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}