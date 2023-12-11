package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.common.datetime.WeekDay;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "planning_daily"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "planning_daily", schema = "agenda")
@SequenceGenerator(name = "default_gen", sequenceName = "agenda.planning_daily_seq", allocationSize = 1)
@Getter
@Setter
public class PlanningDaily extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "planning_id", referencedColumnName = "id")
	private Planning planning;

	@Column(name = "day")
	@Enumerated(EnumType.STRING)
	private WeekDay day;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Column(name = "total_patients")
	private Integer totalPatients;

	@Column(name = "total_extra_slot")
	private Integer totalExtraSlot;
	
	@Version
	private Long version;

	public PlanningDaily() {
	}

	public PlanningDaily(WeekDay day, LocalTime startTime, LocalTime endTime, Integer totalPatients,
			Integer totalExtraSlot) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalPatients = totalPatients;
		this.totalExtraSlot = totalExtraSlot;
	}
	
	public PlanningDaily(Planning planning, WeekDay day, LocalTime startTime, LocalTime endTime, Integer totalPatients,
			Integer totalExtraSlot) {
		this.planning = planning;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalPatients = totalPatients;
		this.totalExtraSlot = totalExtraSlot;
	}

	@Override
	public String toString() {
		return "PlanningDaily [id=" + id + ", planning=" + planning.getId() + ", day=" + day + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", totalPatients=" + totalPatients + ", totalExtraSlot=" + totalExtraSlot
				+ ", version=" + version + "]";
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		Class<?> oEffectiveClass = o instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
			: o.getClass();
		Class<?> thisEffectiveClass = this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass()
			: this.getClass();
		if (thisEffectiveClass != oEffectiveClass) return false;
		PlanningDaily that = (PlanningDaily) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}