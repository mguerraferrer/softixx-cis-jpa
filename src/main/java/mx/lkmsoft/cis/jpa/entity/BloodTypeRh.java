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
 * Persistent class for entity stored in table "blood_type"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "blood_type_rh", schema = "nomenclators")
@SequenceGenerator(name = "default_gen", sequenceName = "nomenclators.blood_type_rh_id_seq", allocationSize = 1)
public class BloodTypeRh extends NomenclatorEntity {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bloodTypeRh", targetEntity = Patient.class)
	private List<Patient> patients;

	/* Getters and Setters */
	public List<Patient> getPatients() {
		if (patients == null) {
			patients = new ArrayList<>();
		}
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	/* toString */
	@Override
	public String toString() {
		return "PaymentMode [id=" + id + ", code=" + code + ", value=" + value + ", active=" + active + "]";
	}

}