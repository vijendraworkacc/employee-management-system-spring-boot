package com.te.ems.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.checkerframework.common.aliasing.qual.Unique;

import com.te.ems.entity.enums.Gender;

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
@ToString
@Builder
@Entity
public class Employee {
	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_email")
	@Unique
	private String empEmail;
	@Column(name = "emp_dob")
	private LocalDate empDOB;
	@Column(name = "emp_doj")
	private LocalDate empDOJ;

	@Enumerated(EnumType.STRING)
	@Column(name = "emp_gender")
	private Gender empGender;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "si_fk")
	private SecondaryInfo secondaryInfo;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<EducationalDetails> educationalDetails;

	@ManyToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	private List<ProjectDetails> projectDetails;
}
