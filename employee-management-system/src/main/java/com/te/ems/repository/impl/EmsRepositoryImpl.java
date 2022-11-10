package com.te.ems.repository.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.te.ems.entity.Employee;
import com.te.ems.repository.EmsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EmsRepositoryImpl implements EmsRepository {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public Optional<Integer> registration(Employee employee) {
		log.info("EmsRepositoryImpl:registration persist logic for registration started, {}", employee);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		log.info("EmsRepositoryImpl:registration returning the data");
		return Optional.ofNullable(employee.getEmpId());
	}
}
