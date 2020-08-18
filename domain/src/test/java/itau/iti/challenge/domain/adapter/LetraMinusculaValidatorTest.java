package itau.iti.challenge.domain.adapter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import itau.iti.challenge.domain.model.Credential;

@TestInstance(Lifecycle.PER_CLASS)
class LetraMinusculaValidatorTest {

	@Test
	void testIsValid() {
		assertTrue(new LetraMinusculaValidator().isValid(Credential.builder().password("AAAbbbCc").build()));
	}
	
	@Test
	void testIsInValid() {
		assertFalse(new LetraMinusculaValidator().isValid(Credential.builder().password("AAAOOUUEERR").build()));
	}

}
