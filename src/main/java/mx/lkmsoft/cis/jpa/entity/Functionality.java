package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "functionality"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "functionality", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.functionality_id_seq", allocationSize = 1)
public class Functionality extends BaseEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "functionality_id", referencedColumnName = "id")
	private Functionality functionality;

	@Column(name = "name")
	private String name;

	@Column(name = "order")
	private Integer order;

	@Column(name = "module")
	private boolean module;

	@Column(name = "menu")
	private boolean menu;

	@Column(name = "visible")
	private boolean visible;

	@Column(name = "root")
	private boolean root;

	@Column(name = "code")
	private String code;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "functionality", targetEntity = Functionality.class)
	private List<Functionality> functionalities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "functionality", targetEntity = AutoConfigFunctionality.class)
	private List<AutoConfigFunctionality> autoConfigFunctionalities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "functionality", targetEntity = AutoConfigFunctionalityRole.class)
	private List<AutoConfigFunctionalityRole> autoConfigFunctionalityRoles;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "functionality", targetEntity = PrivatePracticeFunctionality.class)
	private List<PrivatePracticeFunctionality> privatePracticeFunctionalities;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "functionality", targetEntity = ClinicalEntityFunctionality.class)
	private List<ClinicalEntityFunctionality> clinicalEntityFunctionalities;

	/* Getters and Setters */
	public Functionality getFunctionality() {
		return functionality;
	}

	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public boolean isModule() {
		return module;
	}

	public void setModule(boolean module) {
		this.module = module;
	}

	public boolean isMenu() {
		return menu;
	}

	public void setMenu(boolean menu) {
		this.menu = menu;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setFunctionalities(List<Functionality> functionalities) {
		this.functionalities = functionalities;
	}

	public List<Functionality> getFunctionalities() {
		if (functionalities == null) {
			functionalities = new ArrayList<>();
		}
		return functionalities;
	}

	public List<AutoConfigFunctionality> getAutoConfigFunctionalities() {
		if (autoConfigFunctionalities == null) {
			autoConfigFunctionalities = new ArrayList<>();
		}
		return autoConfigFunctionalities;
	}

	public void setAutoConfigFunctionalities(List<AutoConfigFunctionality> autoConfigFunctionalities) {
		this.autoConfigFunctionalities = autoConfigFunctionalities;
	}

	public List<AutoConfigFunctionalityRole> getAutoConfigFunctionalityRoles() {
		if (autoConfigFunctionalityRoles == null) {
			autoConfigFunctionalityRoles = new ArrayList<>();
		}
		return autoConfigFunctionalityRoles;
	}

	public void setAutoConfigFunctionalityRoles(List<AutoConfigFunctionalityRole> autoConfigFunctionalityRoles) {
		this.autoConfigFunctionalityRoles = autoConfigFunctionalityRoles;
	}

	public List<PrivatePracticeFunctionality> getPrivatePracticeFunctionalities() {
		if (privatePracticeFunctionalities == null) {
			privatePracticeFunctionalities = new ArrayList<>();
		}
		return privatePracticeFunctionalities;
	}

	public void setPrivatePracticeFunctionalities(List<PrivatePracticeFunctionality> privatePracticeFunctionalities) {
		this.privatePracticeFunctionalities = privatePracticeFunctionalities;
	}

	public List<ClinicalEntityFunctionality> getClinicalEntityFunctionalities() {
		if (clinicalEntityFunctionalities == null) {
			clinicalEntityFunctionalities = new ArrayList<>();
		}
		return clinicalEntityFunctionalities;
	}

	public void setClinicalEntityFunctionalities(List<ClinicalEntityFunctionality> clinicalEntityFunctionalities) {
		this.clinicalEntityFunctionalities = clinicalEntityFunctionalities;
	}

	/* toString */
	@Override
	public String toString() {
		long functionalityId = functionality != null ? functionality.getId() : null;

		return "Functionality [id=" + id + ", functionality=" + functionalityId + ", module=" + module + ", menu="
				+ menu + ", order=" + order + ", visible=" + visible + ", name=" + name + ", root=" + root + ", code="
				+ code + ", active=" + active + "]";
	}

}