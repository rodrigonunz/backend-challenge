package itau.iti.challenge.adapterrestapi.dto;

import com.fasterxml.jackson.annotation.JsonView;

import itau.iti.challenge.adapterrestapi.MapToModel;
import itau.iti.challenge.adapterrestapi.Views;
import itau.iti.challenge.domain.model.Credential;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CredentialDto implements MapToModel<Credential> {
	
	private String password;
	
	@JsonView(Views.CredentialValidation.class)
	private Boolean valid;
	
	@Override
	public Credential map() {
		return Credential.builder().password(this.password).build();
	}

}
