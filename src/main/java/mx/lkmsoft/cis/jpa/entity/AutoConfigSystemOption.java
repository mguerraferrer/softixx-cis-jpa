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
 * Persistent class for entity stored in table "auto_config_system_option"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "auto_config_system_option", schema = "config")
@SequenceGenerator(name = "default_gen", sequenceName = "config.auto_config_system_option_id_seq", allocationSize = 1)
public class AutoConfigSystemOption extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auto_config_system_option_id", referencedColumnName = "id")
	private AutoConfigSystemOption autoConfigSystemOption;

	@Column(name = "name", length = 250)
	private String name;

	@Column(name = "description", length = 250)
	private String description;

	@Column(name = "block")
	private Integer block;

	@Column(name = "order")
	private Integer order;

	@Column(name = "icon", length = 250)
	private String icon;

	@Column(name = "url", length = 250)
	private String url;

	@Column(name = "view", length = 250)
	private String view;

	@Column(name = "classic")
	private boolean classic;

	@Column(name = "master")
	private boolean master;

	@Column(name = "premium")
	private boolean premium;

	@Column(name = "gold")
	private boolean gold;

	@Column(name = "platinum")
	private boolean platinum;

	@Column(name = "black")
	private boolean black;

	@Column(name = "demo")
	private boolean demo;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autoConfigSystemOption", targetEntity = AutoConfigSystemOption.class)
	private List<AutoConfigSystemOption> autoConfigSystemOptions;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autoConfigSystemOption", targetEntity = ClinicalEntitySystemOption.class)
	private List<ClinicalEntitySystemOption> clinicalEntitySystemOptions;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autoConfigSystemOption", targetEntity = PrivatePracticeSystemOption.class)
	private List<PrivatePracticeSystemOption> privatePracticeSystemOptions;

	/* Getters and Setters */
	public AutoConfigSystemOption getAutoConfigSystemOption() {
		return autoConfigSystemOption;
	}

	public void setAutoConfigSystemOption(AutoConfigSystemOption autoConfigSystemOption) {
		this.autoConfigSystemOption = autoConfigSystemOption;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getBlock() {
		return block;
	}

	public void setBlock(Integer block) {
		this.block = block;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public boolean isClassic() {
		return classic;
	}

	public void setClassic(boolean classic) {
		this.classic = classic;
	}

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public boolean isGold() {
		return gold;
	}

	public void setGold(boolean gold) {
		this.gold = gold;
	}

	public boolean isPlatinum() {
		return platinum;
	}

	public void setPlatinum(boolean platinum) {
		this.platinum = platinum;
	}

	public boolean isBlack() {
		return black;
	}

	public void setBlack(boolean black) {
		this.black = black;
	}

	public boolean isDemo() {
		return demo;
	}

	public void setDemo(boolean demo) {
		this.demo = demo;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<AutoConfigSystemOption> getAutoConfigSystemOptions() {
		if (autoConfigSystemOptions == null) {
			autoConfigSystemOptions = new ArrayList<>();
		}
		return autoConfigSystemOptions;
	}

	public void setAutoConfigSystemOptions(List<AutoConfigSystemOption> autoConfigSystemOptions) {
		this.autoConfigSystemOptions = autoConfigSystemOptions;
	}

	public List<ClinicalEntitySystemOption> getClinicalEntitySystemOptions() {
		if (clinicalEntitySystemOptions == null) {
			clinicalEntitySystemOptions = new ArrayList<>();
		}
		return clinicalEntitySystemOptions;
	}

	public void setClinicalEntitySystemOptions(List<ClinicalEntitySystemOption> clinicalEntitySystemOptions) {
		this.clinicalEntitySystemOptions = clinicalEntitySystemOptions;
	}

	public List<PrivatePracticeSystemOption> getPrivatePracticeSystemOptions() {
		if (privatePracticeSystemOptions == null) {
			privatePracticeSystemOptions = new ArrayList<>();
		}
		return privatePracticeSystemOptions;
	}

	public void setPrivatePracticeSystemOptions(List<PrivatePracticeSystemOption> privatePracticeSystemOptions) {
		this.privatePracticeSystemOptions = privatePracticeSystemOptions;
	}

	/* toString */
	@Override
	public String toString() {
		long autoConfigSystemOptionId = autoConfigSystemOption != null ? autoConfigSystemOption.getId() : null;

		return "AutoConfigSystemOption [id=" + id + ", autoConfigSystemOption=" + autoConfigSystemOptionId + ", name="
				+ name + ", description=" + description + ", block=" + block + ", order=" + order + ", icon=" + icon
				+ ", url=" + url + ", view=" + view + ", classic=" + classic + ", master=" + master + ", premium="
				+ premium + ", gold=" + gold + ", platinum=" + platinum + ", black=" + black + ", demo=" + demo
				+ ", active=" + active + "]";
	}

}