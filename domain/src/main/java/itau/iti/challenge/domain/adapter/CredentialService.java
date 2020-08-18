package itau.iti.challenge.domain.adapter;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import itau.iti.challenge.domain.model.Credential;
import itau.iti.challenge.domain.port.ValidateCredentialService;

@Component
public class CredentialService implements ValidateCredentialService {

	@Override
	public boolean isValid(Credential credential) {
		Optional<CredentialStepValidation> first = Stream
				.of(new EspacoEmBrancoValidator(), 
						new LetraMaiusculaValidator(), 
						new CaracterEspecialValidator(),
						new CaracteresRepetidosValidator(), 
						new LetraMinusculaValidator(),
						new QuantidadeCaracteresValidator(), 
						new QuantidadeDigitoValidator())
				.filter(a -> !a.isValid(credential)).findFirst();

		return !first.isPresent();
	}

}
