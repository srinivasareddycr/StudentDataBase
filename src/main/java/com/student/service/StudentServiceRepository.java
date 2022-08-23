package com.student.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.Students;

public interface StudentServiceRepository  extends JpaRepository<Students, Integer>{

	public List<Students> findByStandard(String standard);
}
