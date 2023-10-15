package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "non_working_day"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "non_working_day", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.non_working_day_seq", allocationSize = 1)
public class NonWorkingDay extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medical_schedule_id", referencedColumnName = "id")
	private MedicalSchedule medicalSchedule;

	@Column(name = "nwd")
	private LocalDate nwd;

	public NonWorkingDay() {
	}

	public NonWorkingDay(MedicalSchedule medicalSchedule, LocalDate nwd) {
		this.medicalSchedule = medicalSchedule;
		this.nwd = nwd;
	}

	/* Getters and Setters */
	public MedicalSchedule getMedicalSchedule() {
		return medicalSchedule;
	}

	public void setMedicalSchedule(MedicalSchedule medicalSchedule) {
		this.medicalSchedule = medicalSchedule;
	}

	public LocalDate getNwd() {
		return nwd;
	}

	public void setNwd(LocalDate nwd) {
		this.nwd = nwd;
	}

	/* toString */
	@Override
	public String toString() {
		return "NonWorkingDay [id=" + id + ", medicalSchedule=" + medicalSchedule.getId() + ", nwd=" + nwd + "]";
	}

}