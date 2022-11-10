package com.te.ems.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sun.xml.txw2.IllegalSignatureException;
import com.te.ems.dto.RegistrationDto;
import com.te.ems.response.GeneralResponse;
import com.te.ems.service.EmsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class EmsController {

	private final EmsService emsService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(path = "/registration")
	public GeneralResponse<Integer> registration(@RequestBody RegistrationDto registrationDto) {
		log.info("EmsController:registration execution started, trying to register user with data {}", registrationDto);
		Optional<Integer> empId = emsService.registration(registrationDto);
		if (empId.isPresent()) {
			log.debug("EmsController:registration returning the response");
			return new GeneralResponse<Integer>("Registration successfull", empId.get());
		} else {
			log.debug("EmsController:registration throwing execption");
			throw new IllegalSignatureException("Registration not successfull!");
		}
	}

}
