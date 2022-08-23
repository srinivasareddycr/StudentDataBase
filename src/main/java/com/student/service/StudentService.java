package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.model.Students;

public interface StudentService {

	
	public int createStudents(Students students);
	
	public List<Students> getAllStudents();
	
	public Optional<Students> findStudentsById(int id);
	
	public void deleteStudent(Students students);
	
	public void deleteStudentsById(int id);
	
	public Students updateStudent(Students students, int id);
	
	public List<Students> getStudenstByClass(String standard);
	
	}
