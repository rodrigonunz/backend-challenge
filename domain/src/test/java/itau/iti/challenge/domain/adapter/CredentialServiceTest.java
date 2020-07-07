package itau.iti.challenge.domain.adapter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import itau.iti.challenge.domain.model.Credential;

@TestInstance(Lifecycle.PER_CLASS)
public class CredentialServiceTest {
	
	private CredentialService service;
	
	@BeforeAll
	void init() {
		service = new CredentialService();
	}

	@Test
	void testIsValid_Valids() {
		assertTrue(service.isValid(Credential.builder().password("AbTp9!fok").build()));
		
		assertTrue(service.isValid(Credential.builder().password("Abcdefg1+").build()));
		assertTrue(service.isValid(Credential.builder().password("Abcdefg1/").build()));
		assertTrue(service.isValid(Credential.builder().password("Abcdefg1*").build()));
		assertTrue(service.isValid(Credential.builder().password("Abcdefg1-").build()));
		assertTrue(service.isValid(Credential.builder().password("Abcdefg1.").build()));
		assertTrue(service.isValid(Credential.builder().password("024156Rn*").build()));
		assertTrue(service.isValid(Credential.builder().password("0-(/24156Rn*").build()));
	}
	
	@Test
	void testIsValid_Invalids() {
		assertFalse(service.isValid(Credential.builder().password("").build())); 
		assertFalse(service.isValid(Credential.builder().password("aa").build()));
		assertFalse(service.isValid(Credential.builder().password("ab").build()));
		assertFalse(service.isValid(Credential.builder().password("AAAbbbCc").build()));
		assertFalse(service.isValid(Credential.builder().password("AbTp9!foo").build()));
		assertFalse(service.isValid(Credential.builder().password("AbTp9!foA").build()));
		assertFalse(service.isValid(Credential.builder().password("AbTp9 fok").build()));
		
		assertFalse(service.isValid(Credential.builder().password(" ").build()));
		assertFalse(service.isValid(Credential.builder().password("Abcdfg1+").build())); //8chars
		assertFalse(service.isValid(Credential.builder().password("Abcefg1.").build())); //8chars
		assertFalse(service.isValid(Credential.builder().password("abc efg1-").build())); //8chars
		assertFalse(service.isValid(Credential.builder().password("0241564RUn*").build()));
		assertFalse(service.isValid(Credential.builder().password("0241564RUn* ").build()));
		assertFalse(service.isValid(Credential.builder().password(" 0241564RUn* ").build()));
		assertFalse(service.isValid(Credential.builder().password("AbTp9!fok ").build()));
		assertFalse(service.isValid(Credential.builder().password(" AbTp9!fok ").build()));
		assertFalse(service.isValid(Credential.builder().password("AbTp9! fok").build()));
	}

}
