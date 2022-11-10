package com.te.ems.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@ToString(exclude = { "employees" })
@Entity
@Table(name = "project_details")
public class ProjectDetails {
	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;
	@Column(name = "project_name")
	private String projectName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "map_pd_emp", joinColumns = @JoinColumn(name = "pd_fk"), inverseJoinColumns = @JoinColumn(name = "emp_fk"))
	private List<Employee> employees;
}
