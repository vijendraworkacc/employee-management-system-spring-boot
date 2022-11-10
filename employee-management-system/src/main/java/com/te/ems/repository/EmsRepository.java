package com.te.ems.repository;

import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.te.ems.entity.Employee;

public interface EmsRepository {

	Optional<Integer> registration(Employee employee);

}
