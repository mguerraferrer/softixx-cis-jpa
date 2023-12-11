package mx.lkmsoft.cis.jpa.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * @author Maikel Guerra Ferrer
 *
 */
@Embeddable
@Getter
@Setter
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
	
}