package itau.iti.challenge.domain.adapter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import itau.iti.challenge.domain.model.Credential;

@TestInstance(Lifecycle.PER_CLASS)
class CaracteresRepetidosValidatorTest {

	@Test
	void testIsValid() {
		assertTrue(new CaracteresRepetidosValidator().isValid(Credential.builder().password("Abcdefg1*").build()));
	}
	
	@Test
	void testIsInValid() {
		assertFalse(new CaracteresRepetidosValidator().isValid(Credential.builder().password("Abcdefg13ff").build()));
	}

}
