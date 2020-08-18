package itau.iti.challenge.domain.adapter;

import itau.iti.challenge.domain.model.Credential;

public class CaracteresRepetidosValidator implements CredentialStepValidation {

	@Override
	public boolean isValid(final Credential credential) {
		String[] splitted = credential.getPassword().split("");
		for(int i = 0 ; i< splitted.length; i++) {
			if(i+1 == splitted.length)
				break;
			
			for(int o = 0 ; o< splitted.length; o++) {
				if(i==o)
					continue;
				
				if(splitted[i].equals(splitted[o]))
					return false;
			}
		}
		
		return true;
	}

}
