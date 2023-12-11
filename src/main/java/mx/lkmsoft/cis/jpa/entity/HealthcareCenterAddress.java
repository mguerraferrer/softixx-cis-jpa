package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableAddress;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * Persistent class for entity stored in table "healthcare_center_address"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "healthcare_center_address", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.healthcare_center_address_seq", allocationSize = 1)
@Getter
@Setter
public class HealthcareCenterAddress extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "healthcare_center_id", referencedColumnName = "id")
	private HealthcareCenter healthcareCenter;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colony_id", referencedColumnName = "id")
	protected Colony colony;

	@Embedded
	private EmbeddableAddress address;

	/* toString */
	@Override
	public String toString() {
		return "HealthcareCenterAddress [id=" + id + ", healthcareCenter=" + healthcareCenter.getId() + ", colony="
				+ colony.getId() + ", address=" + address + "]";
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
		HealthcareCenterAddress that = (HealthcareCenterAddress) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}