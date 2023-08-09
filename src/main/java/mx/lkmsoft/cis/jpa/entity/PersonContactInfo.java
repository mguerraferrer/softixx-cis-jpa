package mx.lkmsoft.cis.jpa.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import mx.lkmsoft.cis.jpa.base.BaseEntity;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * Persistent class for entity stored in table "person_contact_info"
 *
 * @author Maikel Guerra Ferrer
 *
 */

@Entity
@Table(name = "person_contact_info", schema = "common")
@SequenceGenerator(name = "default_gen", sequenceName = "common.person_contact_info_id_seq", allocationSize = 1)
public class PersonContactInfo extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
	
    @Column(name = "phone1")
    @Convert(converter = AttributeEncryptor.class)
    private String phone1;

    @Column(name = "phone2")
    @Convert(converter = AttributeEncryptor.class)
    private String phone2;

    @Column(name = "phone3")
    @Convert(converter = AttributeEncryptor.class)
    private String phone3;

    @Column(name = "mobile1")
    @Convert(converter = AttributeEncryptor.class)
    private String mobile1;

    @Column(name = "mobile2")
    @Convert(converter = AttributeEncryptor.class)
    private String mobile2;

    @Column(name = "mobile3")
    @Convert(converter = AttributeEncryptor.class)
    private String mobile3;

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

    @Column(name = "hash")
    private String hash;

    @Column(name = "active")
    private boolean active;

    public PersonContactInfo() {
    }
    
    public PersonContactInfo(Person person) {
		this.person = person;
		this.email1 = "";
		this.email2 = "";
		this.email3 = "";
		this.mobile1 = "";
		this.mobile2 = "";
		this.mobile3 = "";
		this.phone1 = "";
		this.phone2 = "";
		this.phone3 = "";
		this.web = "";
		this.blog = "";
		this.facebook = "";
		this.twitter = "";
		this.instagram = "";
		this.linkedin = "";
		this.youtube = "";
		this.hash = UUID.randomUUID().toString().replace("-", "");
		this.active = true;
    }
    
    public PersonContactInfo(Person person, String email1, String mobile1) {
		this.person = person;
		this.email1 = email1;
		this.email2 = "";
		this.email3 = "";
		this.mobile1 = mobile1;
		this.mobile2 = "";
		this.mobile3 = "";
		this.phone1 = "";
		this.phone2 = "";
		this.phone3 = "";
		this.web = "";
		this.blog = "";
		this.facebook = "";
		this.twitter = "";
		this.instagram = "";
		this.linkedin = "";
		this.youtube = "";
		this.hash = UUID.randomUUID().toString().replace("-", "");
		this.active = true;
    }

    /* Getters and Setters */
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

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getMobile3() {
		return mobile3;
	}

	public void setMobile3(String mobile3) {
		this.mobile3 = mobile3;
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

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	/* toString */
	@Override
	public String toString() {
		return "PersonContactInfo [id=" + id + ", person=" + person.getId() + ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3="
				+ phone3 + ", mobile1=" + mobile1 + ", mobile2=" + mobile2 + ", mobile3=" + mobile3 + ", email1="
				+ email1 + ", email2=" + email2 + ", email3=" + email3 + ", web=" + web + ", blog=" + blog
				+ ", facebook=" + facebook + ", twitter=" + twitter + ", instagram=" + instagram + ", linkedin="
				+ linkedin + ", youtube=" + youtube + ", hash=" + hash + ", active=" + active + "]";
	}

}