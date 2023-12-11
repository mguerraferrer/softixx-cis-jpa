package mx.lkmsoft.cis.jpa.entity;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.common.collection.ListUtils;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "planning_fixed"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "planning_fixed", schema = "agenda")
@Getter
@Setter
public class PlanningFixed {
	
	@Id
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private Planning planning;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	@Column(name = "total_patients")
	private Integer totalPatients;

	@Column(name = "total_extra_slot")
	private Integer totalExtraSlot;

	@Column(name = "days")
	private String days;
	
	@Version
	private Long version;

	public PlanningFixed() {
	}

	public PlanningFixed(LocalTime startTime, LocalTime endTime, Integer totalPatients, Integer totalExtraSlot,
			String days) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalPatients = totalPatients;
		this.totalExtraSlot = totalExtraSlot;
		this.days = days;
	}
	
	public static PlanningFixed clone(PlanningFixed planningFixed) {
		return new PlanningFixed(planningFixed.getStartTime(), planningFixed.getEndTime(),
				planningFixed.getTotalPatients(), planningFixed.getTotalExtraSlot(), planningFixed.getDays());
	}

	@Transient
	public boolean isAllWeek() {
		return ListUtils.toList(days).size() == 7;
	}
	
	@Transient
	public List<String> weekDays() {
		return ListUtils.toList(days);
	}

	/* toString */
	@Override
	public String toString() {
		return "PlanningFixed [id=" + id + ", planning=" + planning.getId() + ", startTime=" + startTime + ", endTime="
				+ endTime + ", totalPatients=" + totalPatients + ", totalExtraSlot=" + totalExtraSlot + ", days=" + days
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
		PlanningFixed that = (PlanningFixed) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}