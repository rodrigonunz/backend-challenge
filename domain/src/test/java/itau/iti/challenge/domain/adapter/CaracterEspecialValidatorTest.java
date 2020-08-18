package itau.iti.challenge.domain.adapter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import itau.iti.challenge.domain.model.Credential;

@TestInstance(Lifecycle.PER_CLASS)
class CaracterEspecialValidatorTest {

	@Test
	void testIsValid() {
		assertTrue(new CaracterEspecialValidator().isValid(Credential.builder().password("Abcdefg1*").build()));
		assertTrue(new CaracterEspecialValidator().isValid(Credential.builder().password("Ab[cdefg1*").build()));
		assertTrue(new CaracterEspecialValidator().isValid(Credential.builder().password("Ab[cdefg$@#").build()));
	}
	
	@Test
	void testIsInValid() {
		assertFalse(new CaracterEspecialValidator().isValid(Credential.builder().password(" ").build()));
		assertFalse(new CaracterEspecialValidator().isValid(Credential.builder().password("asdaDS ").build()));
	}

}
