package itau.iti.challenge.domain.adapter;



import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import itau.iti.challenge.domain.model.Credential;

public class LetraMinusculaValidator implements CredentialStepValidation {

	@Override
	public boolean isValid(final Credential credential) {
		String[] splitted = credential.getPassword().split("");
		Optional<String> findFirst = Stream.of(splitted).filter(a -> StringUtils.isAllLowerCase(a)).findFirst();
		return findFirst.isPresent(); 
	}

}
