package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "city"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "city", schema = "address")
@SequenceGenerator(name = "default_gen", sequenceName = "address.city_id_seq", allocationSize = 1)
public class City extends BaseEntity {

	@Column(name = "value")
	private String value;

	@Column(name = "active")
	private boolean active;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id", referencedColumnName = "id")
	private State state;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city", targetEntity = Colony.class)
	private List<Colony> colonies;

	/* Getters and Setters */
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Colony> getColonies() {
		if (colonies == null) {
			colonies = new ArrayList<>();
		}
		return colonies;
	}

	public void setColonies(List<Colony> colonies) {
		this.colonies = colonies;
	}

	/* toString */
	@Override
	public String toString() {
		return "City [id=" + id + ", value=" + value + ", active=" + active + ", state=" + state.getId() + "]";
	}

}