package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.NomenclatorEntity;

/**
 * Persistent class for entity stored in table "theme"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "theme", schema = "nomenclators")
@SequenceGenerator(name = "default_gen", sequenceName = "nomenclators.theme_id_seq", allocationSize = 1)
public class Theme extends NomenclatorEntity {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "theme", targetEntity = UserPreferences.class)
	private List<UserPreferences> userPreferences;

	/* Getters and Setters */
	public List<UserPreferences> getPreferences() {
		if (userPreferences == null) {
			userPreferences = new ArrayList<>();
		}
		return userPreferences;
	}

	public void setPreferences(List<UserPreferences> userPreferences) {
		this.userPreferences = userPreferences;
	}

	/* toString */
	@Override
	public String toString() {
		return "PaymentSource [id=" + id + ", code=" + code + ", value=" + value + ", active=" + active + "]";
	}

}