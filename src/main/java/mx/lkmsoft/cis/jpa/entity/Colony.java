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
 * Persistent class for entity stored in table "colony"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "colony", schema = "address")
@SequenceGenerator(name = "default_gen", sequenceName = "address.colony_seq", allocationSize = 1)
@Getter
@Setter
public class Colony extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postal_code_id", referencedColumnName = "id")
	private PostalCode postalCode;

	@Column(name = "value")
	private String value;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colony", targetEntity = HealthcareCenterAddress.class)
	@Getter(AccessLevel.NONE)
	private List<HealthcareCenterAddress> healthcareCenterAddresses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "colony", targetEntity = PersonAddress.class)
	@Getter(AccessLevel.NONE)
	private List<PersonAddress> personAddresses;

	public List<HealthcareCenterAddress> getHealthcareCenterAddresses() {
		if (healthcareCenterAddresses == null) {
			healthcareCenterAddresses = new ArrayList<>();
		}
		return healthcareCenterAddresses;
	}

	public List<PersonAddress> getPersonAddresses() {
		if (personAddresses == null) {
			personAddresses = new ArrayList<>();
		}
		return personAddresses;
	}

	/* toString */
	@Override
	public String toString() {
		return "Colony [id=" + id + ", value=" + value + ", active=" + active + ", city=" + city.getId()
				+ ", postalCode=" + postalCode.getId() + "]";
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
		Colony colony = (Colony) o;
		return getId() != null && Objects.equals(getId(), colony.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}