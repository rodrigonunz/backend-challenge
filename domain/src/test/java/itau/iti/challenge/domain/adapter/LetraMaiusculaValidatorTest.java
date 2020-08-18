package itau.iti.challenge.domain.adapter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import itau.iti.challenge.domain.model.Credential;

@TestInstance(Lifecycle.PER_CLASS)
class LetraMaiusculaValidatorTest {

	@Test
	void testIsValid() {
		assertTrue(new LetraMaiusculaValidator().isValid(Credential.builder().password("AAAbbbCc").build()));
	}
	
	@Test
	void testIsInValid() {
		assertFalse(new LetraMaiusculaValidator().isValid(Credential.builder().password("aaabbbcccooo").build()));
	}

}
