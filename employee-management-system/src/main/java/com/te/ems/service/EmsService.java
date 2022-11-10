package com.te.ems.service;

import java.util.Optional;

import com.te.ems.dto.RegistrationDto;

public interface EmsService {

	Optional<Integer> registration(RegistrationDto registrationDto);

}
