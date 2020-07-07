package itau.iti.challenge.domain.port;

import itau.iti.challenge.domain.model.Credential;

@FunctionalInterface
public interface ValidateCredentialService {

	boolean isValid(Credential credential);

}
