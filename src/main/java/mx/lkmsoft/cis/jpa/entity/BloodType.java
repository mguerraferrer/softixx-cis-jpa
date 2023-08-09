package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Entity;
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
@Table(name = "blood_type", schema = "nomenclators")
@SequenceGenerator(name = "default_gen", sequenceName = "nomenclators.blood_type_id_seq", allocationSize = 1)
public class BloodType extends NomenclatorEntity {

	/* toString */
	@Override
	public String toString() {
		return "PaymentMode [id=" + id + ", code=" + code + ", value=" + value + ", active=" + active + "]";
	}

}