package itau.iti.challenge.domain.adapter;

import org.apache.commons.lang3.StringUtils;

import itau.iti.challenge.domain.model.Credential;

public class QuantidadeDigitoValidator implements CredentialStepValidation {

	@Override
	public boolean isValid(final Credential credential) {
		return !StringUtils.getDigits(credential.getPassword()).isBlank();
	}

}
