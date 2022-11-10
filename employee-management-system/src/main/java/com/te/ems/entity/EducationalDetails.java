package com.te.ems.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "educational_details")
public class EducationalDetails {
	@Id
	@Column(name = "edu_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eduId;
	@Column(name = "edu_name")
	private String eduType;
	@Column(name = "edu_py")
	private LocalDate eduPY;
	@Column(name = "edu_percentage")
	private Double eduPercentage;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_fk")
	private Employee employee;
}
