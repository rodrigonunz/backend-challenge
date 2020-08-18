package itau.iti.challenge.domain.adapter;

import itau.iti.challenge.domain.model.Credential;

public class QuantidadeCaracteresValidator implements CredentialStepValidation {
	
	// * Nove ou mais caracteres (^.{9,}) <br/>
	@Override
	public boolean isValid(final Credential credential) {
		return credential.getPassword().length() >= 9;
	}

}
