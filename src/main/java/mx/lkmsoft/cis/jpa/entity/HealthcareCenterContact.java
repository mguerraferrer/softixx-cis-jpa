package mx.lkmsoft.cis.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * Persistent class for entity stored in table "healthcare_center_contact"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "healthcare_center_contact", schema = "common")
public class HealthcareCenterContact {

	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private HealthcareCenter healthcareCenter;

	@Column(name = "phone1")
	@Convert(converter = AttributeEncryptor.class)
	private String phone1;

	@Column(name = "phone2")
	@Convert(converter = AttributeEncryptor.class)
	private String phone2;

	@Column(name = "phone3")
	@Convert(converter = AttributeEncryptor.class)
	private String phone3;

	@Column(name = "email1")
	@Convert(converter = AttributeEncryptor.class)
	private String email1;

	@Column(name = "email2")
	@Convert(converter = AttributeEncryptor.class)
	private String email2;

	@Column(name = "email3")
	@Convert(converter = AttributeEncryptor.class)
	private String email3;

	@Column(name = "web")
	@Convert(converter = AttributeEncryptor.class)
	private String web;

	@Column(name = "blog")
	@Convert(converter = AttributeEncryptor.class)
	private String blog;

	@Column(name = "facebook")
	@Convert(converter = AttributeEncryptor.class)
	private String facebook;

	@Column(name = "twitter")
	@Convert(converter = AttributeEncryptor.class)
	private String twitter;

	@Column(name = "instagram")
	@Convert(converter = AttributeEncryptor.class)
	private String instagram;

	@Column(name = "linkedin")
	@Convert(converter = AttributeEncryptor.class)
	private String linkedin;

	@Column(name = "youtube")
	@Convert(converter = AttributeEncryptor.class)
	private String youtube;

	/* Getters and Setters */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public HealthcareCenter getHealthcareCenter() {
		return healthcareCenter;
	}

	public void setHealthcareCenter(HealthcareCenter healthcareCenter) {
		this.healthcareCenter = healthcareCenter;
	}
	
	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	/* toString */
	@Override
	public String toString() {
		return "HealthcareCenterContact [id=" + id + ", healthcareCenter=" + healthcareCenter.getId() + ", phone1="
				+ phone1 + ", phone2=" + phone2 + ", phone3=" + phone3 + ", email1=" + email1 + ", email2=" + email2
				+ ", email3=" + email3 + ", web=" + web + ", blog=" + blog + ", facebook=" + facebook + ", twitter="
				+ twitter + ", instagram=" + instagram + ", linkedin=" + linkedin + ", youtube=" + youtube + "]";
	}

}