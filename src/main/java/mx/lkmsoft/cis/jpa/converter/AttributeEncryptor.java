package mx.lkmsoft.cis.jpa.converter;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.persistence.AttributeConverter;
import mx.lkmsoft.cis.common.data.StringUtils;

/**
 * Component for encrypting and decrypting entity attributes. This is useful
 * when storing sensitive information in a database. The encryption and
 * decryption is done using the AES algorithm.
 *
 * @author Maikel Guerra Ferrer
 *
 */
@Component
@Converter
public class AttributeEncryptor implements AttributeConverter<String, String> {

	private final Key key;
	private final Cipher cipher;

	/**
	 * Constructs an AttributeEncryptor using the provided secret key.
	 *
	 * @param secretKey the secret key for the AES algorithm.
	 * @throws NoSuchAlgorithmException if the AES algorithm is not available in the
	 *                                  environment.
	 * @throws NoSuchPaddingException   if cipher padding is not available in the
	 *                                  environment.
	 */
	public AttributeEncryptor(@Value("${attribute.encryptor.key}") String secretKey)
			throws NoSuchAlgorithmException, NoSuchPaddingException {
		key = new SecretKeySpec(secretKey.getBytes(), "AES");
		cipher = Cipher.getInstance("AES");
	}

	/**
	 * Converts the provided attribute into its encrypted form for storage in the
	 * database.
	 *
	 * @param attribute the attribute to encrypt.
	 * @return the encrypted form of the attribute.
	 * @throws IllegalStateException if the encryption process encounters an error.
	 */
	@Override
	public String convertToDatabaseColumn(String attribute) {
		try {
			if (StringUtils.hasValue(attribute)) {
				cipher.init(Cipher.ENCRYPT_MODE, key);
				return Base64.getEncoder().encodeToString(cipher.doFinal(attribute.getBytes()));
			}
			return null;
		} catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * Converts the provided database column value into its decrypted form for use
	 * in the entity.
	 *
	 * @param dbData the database column value to decrypt.
	 * @return the decrypted form of the database column value.
	 * @throws IllegalStateException if the decryption process encounters an error.
	 */
	@Override
	public String convertToEntityAttribute(String dbData) {
		try {
			if (StringUtils.hasValue(dbData)) {
				cipher.init(Cipher.DECRYPT_MODE, key);
				return new String(cipher.doFinal(Base64.getDecoder().decode(dbData)));
			}
			return null;
		} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
			throw new IllegalStateException(e);
		}
	}

}