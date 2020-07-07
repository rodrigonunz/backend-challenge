package itau.iti.challenge.domain.adapter;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import itau.iti.challenge.domain.model.Credential;
import itau.iti.challenge.domain.port.ValidateCredentialService;

@Component
public class CredentialService implements ValidateCredentialService {

	@Override
	/**
	 * Valida o password utilizando os seguintes critérios: <br/>
	 * Nove ou mais caracteres (^.{9,}) <br/>
	 * Ao menos 1 dígito (?=.*[0-9]) <br/>
	 * Ao menos 1 letra minúscula (?=.*[a-z]) <br/>
	 * Ao menos 1 letra maiúscula (?=.*[A-Z]) <br/>
	 * Ao menos 1 caractere especial (?=.*[.*@!#%&()^~{}+/-]) <br/>
	 * Não possuir caracteres repetidos dentro do conjunto .*(.).*\1+.*
	 * Nao pode ter espaco em branco
	 * */
	public boolean isValid(Credential credential) {
		final String pass = credential.getPassword();
		boolean m0 = !StringUtils.containsWhitespace(pass);
		boolean m1 = Pattern.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[.*@!#%&()^~{}+/-])(^.{9,})", pass);
		boolean m2 = !Pattern.matches(".*(.).*\\1+.*", pass);
		return m0 & m1 & m2;
	}

}
