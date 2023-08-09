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
 * Persistent class for entity stored in table "relationship_type"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "relationship_type", schema = "nomenclators")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.relationship_type_id_seq", allocationSize = 1)
public class RelationshipType extends NomenclatorEntity {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "relationshipType", targetEntity = Appointment.class)
	private List<Appointment> appointments;

	/* Getters and Setters */
	public List<Appointment> getAppointments() {
		if (appointments == null) {
			appointments = new ArrayList<>();
		}
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	/* toString */
	@Override
	public String toString() {
		return "PaymentMode [id=" + id + ", code=" + code + ", value=" + value + ", active=" + active + "]";
	}

}