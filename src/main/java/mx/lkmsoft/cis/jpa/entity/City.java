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
 * Persistent class for entity stored in table "city"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "city", schema = "address")
@SequenceGenerator(name = "default_gen", sequenceName = "address.city_seq", allocationSize = 1)
@Getter
@Setter
public class City extends BaseEntity {

	@Column(name = "value")
	private String value;

	@Column(name = "active")
	private boolean active;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id", referencedColumnName = "id")
	private State state;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city", targetEntity = Colony.class)
	@Getter(AccessLevel.NONE)
	private List<Colony> colonies;

	public List<Colony> getColonies() {
		if (colonies == null) {
			colonies = new ArrayList<>();
		}
		return colonies;
	}

	/* toString */
	@Override
	public String toString() {
		return "City [id=" + id + ", value=" + value + ", active=" + active + ", state=" + state.getId() + "]";
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
		City city = (City) o;
		return getId() != null && Objects.equals(getId(), city.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}