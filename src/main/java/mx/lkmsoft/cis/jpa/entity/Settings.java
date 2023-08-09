package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "settings"
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Entity
@Table(name = "settings", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.settings_id_seq", allocationSize = 1)
public class Settings extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "url")
	private String url;

	@Column(name = "menu_icon")
	private String menuIcon;

	@Column(name = "order")
	private Integer order;

	@Column(name = "visible")
	private boolean visible;

	@Column(name = "master_account")
	private boolean masterAccount;

	@Column(name = "active")
	private boolean active;

	/* Getters and Setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isMasterAccount() {
		return masterAccount;
	}

	public void setMasterAccount(boolean masterAccount) {
		this.masterAccount = masterAccount;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/* toString */
	@Override
	public String toString() {
		return "Settings [id=" + id + ", name=" + name + ", url=" + url + ", menuIcon=" + menuIcon + ", order=" + order
				+ ", visible=" + visible + ", masterAccount=" + masterAccount + ", active=" + active + "]";
	}

}