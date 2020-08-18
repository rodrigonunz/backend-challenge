package itau.iti.challenge.domain.adapter;

import itau.iti.challenge.domain.model.Credential;

public interface CredentialStepValidation {
	boolean isValid(final Credential credential);
}
