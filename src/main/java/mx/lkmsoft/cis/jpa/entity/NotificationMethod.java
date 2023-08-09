package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.NomenclatorEntity;

/**
 * Persistent class for entity stored in table "notification_method"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "notification_method", schema = "nomenclators")
@SequenceGenerator(name = "default_gen", sequenceName = "nomenclators.notification_method_id_seq", allocationSize = 1)
public class NotificationMethod extends NomenclatorEntity {

	@Column(name = "image")
	private String image;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "notificationMethod", targetEntity = UserPreferences.class)
	private List<UserPreferences> preferenceses;

	/* Getters and Setters */
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<UserPreferences> getPreferenceses() {
		if (preferenceses == null) {
			preferenceses = new ArrayList<>();
		}
		return preferenceses;
	}

	public void setPreferenceses(List<UserPreferences> preferenceses) {
		this.preferenceses = preferenceses;
	}

	/* toString */
	@Override
	public String toString() {
		return "NotificationMethod [id=" + id + ", code=" + code + ", value=" + value + ", image=" + image
				+ ", active=" + active + "]";
	}

}