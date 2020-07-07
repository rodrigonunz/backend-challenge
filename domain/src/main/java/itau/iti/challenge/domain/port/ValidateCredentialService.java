package itau.iti.challenge.domain.port;

import itau.iti.challenge.domain.model.Credential;

public interface ValidateCredentialService {

	boolean isValid(Credential credential);

}
