package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Persistent class for entity stored in table "country"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "country", schema = "address")
@SequenceGenerator(name = "default_gen", sequenceName = "address.country_seq", allocationSize = 1)
@Getter
@Setter
public class Country extends BaseEntity {

	@Column(name = "value")
	protected String value;

	@Column(name = "active")
	protected boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country", targetEntity = State.class)
	@Getter(AccessLevel.NONE)
	private List<State> states;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country", targetEntity = Person.class)
	@Getter(AccessLevel.NONE)
	private List<Person> persons;

	/* Getters and Setters */
	public List<State> getStates() {
		if (states == null) {
			states = new ArrayList<>();
		}
		return states;
	}

	public List<Person> getPersons() {
		if (persons == null) {
			persons = new ArrayList<>();
		}
		return persons;
	}

	/* toString */
	@Override
	public String toString() {
		return "Country [id=" + id + ", value=" + value + ", active=" + active + ", states=" + states + "]";
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
		Country country = (Country) o;
		return getId() != null && Objects.equals(getId(), country.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}
}