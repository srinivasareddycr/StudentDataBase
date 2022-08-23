package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exception.ResourceNotFoundException;
import com.student.model.Students;
@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentServiceRepository studentRepository;
	
	@Override
	public int createStudents(Students students) {
		Students save = studentRepository.save(students);
		return  save.getId();
	 
	}

	@Override
	public List<Students> getAllStudents() {
		List<Students> findAll = studentRepository.findAll();
		return findAll;
	}

	@Override
	public Optional<Students> findStudentsById(int id) {
		Optional<Students> findById = studentRepository.findById(id);
		return findById;
	}

	@Override
	public void deleteStudent(Students students) {
		studentRepository.deleteAll();
		
	}

	@Override
	public void deleteStudentsById(int id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public Students updateStudent(Students students, int id) {
		
	 Students existingStudent =studentRepository.findById(id).orElseThrow(()->
	 new ResourceNotFoundException("Students", "id", id));
	 existingStudent.setFirstName(students.getFirstName());
	 existingStudent.setLastName(students.getLastName());
	 existingStudent.setDob(students.getDob());
	 existingStudent.setStandard(students.getStandard());
	 studentRepository.save(existingStudent);
	 
		return existingStudent;
	}

	@Override
	public List<Students> getStudenstByClass(String standard) {
		
		List<Students> findByStandard = studentRepository.findByStandard(standard);
		return findByStandard;
	}

	


}
