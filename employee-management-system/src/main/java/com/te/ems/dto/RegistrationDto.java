package com.te.ems.dto;

import java.time.LocalDate;
import java.util.List;

import com.te.ems.entity.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RegistrationDto {
	private String empName;
	private String empEmail;
	private LocalDate empDOB;
	private LocalDate empDOJ;
	private Gender empGender;
	private SecondaryInfoDto secondaryInfo;
	private List<EducationalDetailsDto> educationalDetails;
}
