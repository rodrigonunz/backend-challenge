package itau.iti.challenge.adapterrestapi.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import itau.iti.challenge.adapterrestapi.dto.CredentialDto;
import itau.iti.challenge.domain.model.Credential;
import itau.iti.challenge.domain.port.ValidateCredentialService;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class CredentialControllerTest {
	
	@InjectMocks
	private CredentialController controller;
	
	@Mock
	ValidateCredentialService credentialService;
	

	@Test
	void evalValidCredentials() {
		Mockito.when(credentialService.isValid(Mockito.any(Credential.class))).thenReturn(true);
		
		ResponseEntity credentialsEval = controller.credentialsEval(CredentialDto.builder().password("any").build());
		assertTrue(credentialsEval.getStatusCode().equals(HttpStatus.OK));
		assertTrue(((CredentialDto)credentialsEval.getBody()).getValid());
	}
	
	@Test
	void evalInvalidCredentials() {
		Mockito.when(credentialService.isValid(Mockito.any(Credential.class))).thenReturn(false);
		
		ResponseEntity credentialsEval = controller.credentialsEval(CredentialDto.builder().password("any").build());
		assertTrue(credentialsEval.getStatusCode().equals(HttpStatus.BAD_REQUEST));
		assertFalse(((CredentialDto)credentialsEval.getBody()).getValid());
	}

}
