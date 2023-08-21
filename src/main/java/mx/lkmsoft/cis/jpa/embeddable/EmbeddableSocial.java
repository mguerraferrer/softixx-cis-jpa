package mx.lkmsoft.cis.jpa.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Embeddable
public class EmbeddableSocial {
	
	@Column(name = "web")
	@Convert(converter = AttributeEncryptor.class)
	protected String web;

	@Column(name = "blog")
	@Convert(converter = AttributeEncryptor.class)
	protected String blog;

	@Column(name = "facebook")
	@Convert(converter = AttributeEncryptor.class)
	protected String facebook;

	@Column(name = "twitter")
	@Convert(converter = AttributeEncryptor.class)
	protected String twitter;

	@Column(name = "instagram")
	@Convert(converter = AttributeEncryptor.class)
	protected String instagram;

	@Column(name = "linkedin")
	@Convert(converter = AttributeEncryptor.class)
	protected String linkedin;

	@Column(name = "youtube")
	@Convert(converter = AttributeEncryptor.class)
	protected String youtube;
	
	/* Getters and Setters */
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
	
}