package mx.lkmsoft.cis.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;

/**
 * Persistent class for entity stored in table "service"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "available_service", schema = "sales")
@SequenceGenerator(name = "default_gen", sequenceName = "sales.available_service_seq", allocationSize = 1)
public class AvailableService extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "value")
	private String value;

	@Column(name = "image")
	private String image;

	@Column(name = "frequently_payment")
	private boolean frequentlyPayment;

	@Column(name = "order")
	private Integer order;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Double price;

	@Column(name = "active")
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "availableService", targetEntity = LicenseAvailableService.class)
	private List<LicenseAvailableService> licenseAvailableServices;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "availableService", targetEntity = UserLicenseAvailableServ.class)
	private List<UserLicenseAvailableServ> userLicenseServices;

	/* Getters and Setters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isFrequentlyPayment() {
		return frequentlyPayment;
	}

	public void setFrequentlyPayment(boolean frequentlyPayment) {
		this.frequentlyPayment = frequentlyPayment;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<LicenseAvailableService> getLicenseAvailableServices() {
		if (licenseAvailableServices == null) {
			licenseAvailableServices = new ArrayList<>();
		}
		return licenseAvailableServices;
	}

	public void setLicenseAvailableServices(List<LicenseAvailableService> licenseAvailableServices) {
		this.licenseAvailableServices = licenseAvailableServices;
	}

	public List<UserLicenseAvailableServ> getUserLicenseServices() {
		if (userLicenseServices == null) {
			userLicenseServices = new ArrayList<>();
		}
		return userLicenseServices;
	}

	public void setUserLicenseServices(List<UserLicenseAvailableServ> userLicenseServices) {
		this.userLicenseServices = userLicenseServices;
	}

	/* toString */
	@Override
	public String toString() {
		return "AvailableService [id=" + id + ", code=" + code + ", value=" + value + ", image=" + image
				+ ", frequentlyPayment=" + frequentlyPayment + ", order=" + order + ", description="
				+ description + ", price=" + price + ", active=" + active + "]";
	}

}