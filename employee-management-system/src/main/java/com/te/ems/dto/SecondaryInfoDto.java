package com.te.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SecondaryInfoDto {
	private String panNum;
	private String aadhaarNum;
	private String fatherName;
	private String motherName;
}
