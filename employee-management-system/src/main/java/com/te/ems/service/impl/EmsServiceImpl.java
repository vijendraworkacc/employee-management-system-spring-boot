package com.te.ems.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.te.ems.dto.EducationalDetailsDto;
import com.te.ems.dto.RegistrationDto;
import com.te.ems.entity.EducationalDetails;
import com.te.ems.entity.Employee;
import com.te.ems.entity.SecondaryInfo;
import com.te.ems.repository.EmsRepository;
import com.te.ems.service.EmsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmsServiceImpl implements EmsService {

	private final EmsRepository emsRepository;

	@Override
	public Optional<Integer> registration(RegistrationDto registrationDto) {
		/* Conversion from DTO to Entity */
		log.info("EmsServiceImpl:registration logic for registration service started, {}", registrationDto);
		Employee employee = new Employee();
		SecondaryInfo secondaryInfo = new SecondaryInfo();
		List<EducationalDetails> educationalDetails = Lists.newArrayList();

		log.debug("EmsServiceImpl:registration dto to bean conversion");
		BeanUtils.copyProperties(registrationDto, employee);
		BeanUtils.copyProperties(registrationDto.getSecondaryInfo(), secondaryInfo);
		// BeanUtils.copyProperties(registrationDto.getEducationalDetails(),
		// educationalDetails);
		for (EducationalDetailsDto educationalDetailsDto : registrationDto.getEducationalDetails()) {
			EducationalDetails educationalDetailsEntity = new EducationalDetails();
			BeanUtils.copyProperties(educationalDetailsDto, educationalDetailsEntity);
			educationalDetails.add(educationalDetailsEntity);
		}

		/* Setting objects to each other due to bi-directional mapping */
		employee.setSecondaryInfo(secondaryInfo);
		secondaryInfo.setEmployee(employee);

		employee.setEducationalDetails(educationalDetails);
		for (EducationalDetails ed : educationalDetails) {
			ed.setEmployee(employee);
		}

		log.info("EmsServiceImpl:registration returning the data after calling repository");
		return emsRepository.registration(employee);
	}

}
