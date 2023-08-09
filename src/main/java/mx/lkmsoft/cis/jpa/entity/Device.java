package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.NomenclatorEntity;

/**
 * Persistent class for entity stored in table "device"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "device", schema = "nomenclators")
@SequenceGenerator(name = "default_gen", sequenceName = "nomenclators.device_id_seq", allocationSize = 1)
public class Device extends NomenclatorEntity {

	/* toString */
	@Override
	public String toString() {
		return "LocaleCode [id=" + id + ", code=" + code + ", value=" + value + ", active=" + active + "]";
	}

}