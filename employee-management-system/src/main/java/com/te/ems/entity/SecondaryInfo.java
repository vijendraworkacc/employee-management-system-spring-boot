package com.te.ems.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(exclude = { "employee" })
@Entity
@Table(name = "secondary_info")
public class SecondaryInfo {
	@Id
	@Column(name = "pan_num")
	private String panNum;
	@Column(name = "aadhaar_num")
	private String aadhaarNum;
	@Column(name = "father_name")
	private String fatherName;
	@Column(name = "mother_name")
	private String motherName;

	@OneToOne(mappedBy = "secondaryInfo", cascade = CascadeType.ALL)
	private Employee employee;
}
