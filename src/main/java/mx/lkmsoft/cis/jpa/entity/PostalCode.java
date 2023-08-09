package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "postal_code"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "postal_code", schema = "address")
@SequenceGenerator(name = "default_gen", sequenceName = "address.postal_code_id_seq", allocationSize = 1)
public class PostalCode extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "postalCode", targetEntity = Colony.class)
	private List<Colony> colonies;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		return "PostalCode [id=" + id + ", code=" + code + ", active=" + active + "]";
	}

}