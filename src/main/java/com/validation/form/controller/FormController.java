package com.validation.form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.validation.form.entity.FormData;
import com.validation.form.service.FormService;

@RestController
@RequestMapping("/api/form")
public class FormController {
	@Autowired
	private FormService formService;

//	public FormController (
//			FormService formService,
//			FormRepository formRepository
//			) {
//		this.formService = requireNonNull(formService,"formService must not be null");
//		this.formRepository = requireNonNull(formRepository,"formRepository must not be null");
//	}

//	  @Operation(
//		      summary = "Form Upload",
//		      tags = {"Form"},
//		      description = "To upload the Form")
	@PostMapping("/submit")
	public ResponseEntity<FormData> submitForm(@RequestBody FormData formData) {
		try {
			FormData saveData = formService.saveFormData(formData);
			return ResponseEntity.ok(saveData);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
