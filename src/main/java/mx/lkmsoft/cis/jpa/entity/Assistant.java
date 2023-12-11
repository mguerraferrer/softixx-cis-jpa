package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "assistant"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "assistant", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.assistant_seq", allocationSize = 1)
@Getter
@Setter
public class Assistant extends BaseEntity {

	@OneToOne(mappedBy = "assistant", cascade = CascadeType.ALL)
	private UserProfile userProfile;

	@Column(name = "active")
	private boolean active;

	@ManyToMany(mappedBy = "assistants")
	@Getter(AccessLevel.NONE)
	private List<Doctor> doctors;

	public List<Doctor> getDoctors() {
		if (doctors == null) {
			doctors = new ArrayList<>();
		}
		return doctors;
	}

	/* toString */
	@Override
	public String toString() {
		return "Assistant [id=" + id + ", active=" + active + "]";
	}

}