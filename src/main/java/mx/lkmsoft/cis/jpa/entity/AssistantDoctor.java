package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "assistant_doctor"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "assistant_doctor", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.assistant_doctor_id_seq", allocationSize = 1)
public class AssistantDoctor extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assistant_id", referencedColumnName = "id")
	private Assistant assistant;

	@Column(name = "active")
	private boolean active;

	public AssistantDoctor() {
	}

	public AssistantDoctor(Doctor doctor) {
		this.doctor = doctor;
		this.active = true;
	}

	/* Getters and Setters */
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Assistant getAssistant() {
		return assistant;
	}

	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
	}

	/* toString */
	@Override
	public String toString() {
		return "AssistantDoctor [id=" + id + ", doctor=" + doctor.getId() + ", assistant=" + assistant.getId()
				+ ", active=" + active + "]";
	}

}