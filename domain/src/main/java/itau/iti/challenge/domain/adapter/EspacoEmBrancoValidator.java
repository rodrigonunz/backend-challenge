package itau.iti.challenge.domain.adapter;

import org.springframework.util.StringUtils;

import itau.iti.challenge.domain.model.Credential;

public class EspacoEmBrancoValidator implements CredentialStepValidation {

	@Override
	public boolean isValid(final Credential credential) {
		return !StringUtils.containsWhitespace(credential.getPassword());
	}

}
