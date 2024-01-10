package mx.lkmsoft.cis.jpa.unittest.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lombok.val;
import lombok.extern.slf4j.Slf4j;
import mx.lkmsoft.cis.jpa.converter.AttributeEncryptor;

/**
 * AttributeEncryptor test class
 * 
 * @author Maikel Guerra Ferrer
 *
 */
@Slf4j(topic = "AttributeEncryptorTest")
class AttributeEncryptorTest {
	
	private AttributeEncryptor attributeEncryptor;
    private static final String SECRET_KEY = "a12z3h*8!3ncr1pt0r$5yhcn";

    @BeforeEach
    public void setUp() throws Exception {
        attributeEncryptor = new AttributeEncryptor(SECRET_KEY);
    }

    @Test
    void testConvertToDatabaseColumn_encryption() {
        String input = "HelloWorld";
        String encryptedText = attributeEncryptor.convertToDatabaseColumn(input);
        String decryptedText = attributeEncryptor.convertToEntityAttribute(encryptedText);

        assertEquals(input, decryptedText);
    }

    @Test
    void testConvertToDatabaseColumn_nullValue() {
        String input = null;
        String encryptedText = attributeEncryptor.convertToDatabaseColumn(input);
        assertNull(encryptedText);
    }

    @Test
    void testConvertToEntityAttribute_nullValue() {
        String input = null;
        String decryptedText = attributeEncryptor.convertToEntityAttribute(input);
        assertNull(decryptedText);
    }

	@ParameterizedTest
	@CsvSource({
        "Lorem, Ipsum, Dolor, Lorem Ipsum Dolor",
        "Vivamus, Aliquam, Euismod, Vivamus Aliquam Euismod"
	})
	void testEncryptionThenDecryption(String text1, String text2, String text3, String text4) {
		val text1Encrypted = attributeEncryptor.convertToDatabaseColumn(text1);
		val text2Encrypted = attributeEncryptor.convertToDatabaseColumn(text2);
		val text3Encrypted = attributeEncryptor.convertToDatabaseColumn(text3);
		val text4Encrypted = attributeEncryptor.convertToDatabaseColumn(text4);
		log.info("{}, {}, {}, {}", text1Encrypted, text2Encrypted, text3Encrypted, text4Encrypted);

		assertThat(attributeEncryptor.convertToEntityAttribute(text1Encrypted)).isEqualTo(text1);
		assertThat(attributeEncryptor.convertToEntityAttribute(text2Encrypted)).isEqualTo(text2);
		assertThat(attributeEncryptor.convertToEntityAttribute(text3Encrypted)).isEqualTo(text3);
		assertThat(attributeEncryptor.convertToEntityAttribute(text4Encrypted)).isEqualTo(text4);
	}

}