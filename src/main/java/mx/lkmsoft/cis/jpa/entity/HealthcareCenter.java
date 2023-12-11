package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.common.data.CodeGeneratorUtils;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableAccess;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableContact;
import mx.lkmsoft.cis.jpa.embeddable.EmbeddableSocial;
import org.hibernate.proxy.HibernateProxy;

/**
 * Persistent class for entity stored in table "healthcare_center"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "healthcare_center", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.healthcare_center_seq", allocationSize = 1)
@Getter
@Setter
public class HealthcareCenter extends BaseEntity {

	@Column(name = "name")
	@Convert(converter = AttributeEncryptor.class)
	private String name;

	@Column(name = "business_name")
	@Convert(converter = AttributeEncryptor.class)
	private String businessName;

	@Column(name = "logo")
	private String logo;

	@Column(name = "code")
	private String code;

	@Column(name = "pwd_expiration")
	private Integer pwdExpiration;

	@Embedded
	private EmbeddableAccess access;

	@Embedded
	private EmbeddableSocial social;

	@Embedded
	protected EmbeddableContact contact;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = HealthcareCenterAddress.class)
	@Getter(AccessLevel.NONE)
	private List<HealthcareCenterAddress> healthcareCenterAddresses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = HealthcareCenterAccess.class)
	@Getter(AccessLevel.NONE)
	private List<HealthcareCenterAccess> healthcareCenterAccesses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = HealthcareCenterSpecialty.class)
	@Getter(AccessLevel.NONE)
	private List<HealthcareCenterSpecialty> healthcareCenterSpecialties;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = MasterAccount.class)
	@Getter(AccessLevel.NONE)
	private List<MasterAccount> masterAccounts;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "healthcareCenter", targetEntity = MedicalSchedule.class)
	@Getter(AccessLevel.NONE)
	private List<MedicalSchedule> medicalSchedules;

	public HealthcareCenter() {
	}

	public HealthcareCenter(String name, String businessName) {
		this.name = name;
		this.businessName = businessName;
		this.logo = null;
		this.code = CodeGeneratorUtils.asString();
		this.active = true;
	}

	public List<HealthcareCenterAddress> getHealthcareCenterAddresses() {
		if (healthcareCenterAddresses == null) {
			healthcareCenterAddresses = new ArrayList<>();
		}
		return healthcareCenterAddresses;
	}

	public List<HealthcareCenterAccess> getHealthcareCenterAccesses() {
		if (healthcareCenterAccesses == null) {
			healthcareCenterAccesses = new ArrayList<>();
		}
		return healthcareCenterAccesses;
	}

	public List<HealthcareCenterSpecialty> getHealthcareCenterSpecialties() {
		if (healthcareCenterSpecialties == null) {
			healthcareCenterSpecialties = new ArrayList<>();
		}
		return healthcareCenterSpecialties;
	}

	public List<MasterAccount> getMasterAccounts() {
		if (masterAccounts == null) {
			masterAccounts = new ArrayList<>();
		}
		return masterAccounts;
	}

	public List<MedicalSchedule> getMedicalSchedules() {
		if (medicalSchedules == null) {
			medicalSchedules = new ArrayList<>();
		}
		return medicalSchedules;
	}

	/* toString */
	@Override
	public String toString() {
		return "HealthcareCenter [id=" + id + ", name=" + name + ", businessName=" + businessName + ", logo=" + logo
				+ ", code=" + code + ", access=" + access + ", pwdExpiration=" + pwdExpiration + ", contact=" + contact
				+ ", social=" + social + ", active=" + active + "]";
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
		HealthcareCenter that = (HealthcareCenter) o;
		return getId() != null && Objects.equals(getId(), that.getId());
	}

	@Override
	public final int hashCode() {
		return this instanceof HibernateProxy hibernateProxy
			? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode()
			: getClass().hashCode();
	}

}