package itau.iti.challenge.adapterrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import itau.iti.challenge.adapterrestapi.Views;
import itau.iti.challenge.adapterrestapi.dto.CredentialDto;
import itau.iti.challenge.domain.port.ValidateCredentialService;

@RestController
public class CredentialController {

	@Autowired
	private ValidateCredentialService validationService;

	@RequestMapping(value = "/credentials-eval", method = RequestMethod.POST)
	@JsonView(value = Views.CredentialValidation.class)
	public ResponseEntity credentialsEval(@RequestBody CredentialDto dto) {
		return validationService.isValid(dto.map()) ? ResponseEntity.ok(CredentialDto.builder().valid(true).build())
				: ResponseEntity.badRequest().body(CredentialDto.builder().valid(false).build());
	}

}
