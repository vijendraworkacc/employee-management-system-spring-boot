package com.te.ems.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EducationalDetailsDto {
	private String eduType;
	private LocalDate eduPY;
	private Double eduPercentage;
}
