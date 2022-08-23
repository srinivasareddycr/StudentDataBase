package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Students;
import com.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	
	@PostMapping("/create")
	public int createStudents(@RequestBody Students students)
	{
		int createStudents = studentService.createStudents(students);
		return createStudents;
	}
	
	
	@GetMapping("/get")
	public List<Students> getAllStudents()
	{
		List<Students> allStudents = studentService.getAllStudents();
		return allStudents;
	}
	
	
	@GetMapping("/getId/{id}")
	public Optional<Students> getAllStudentsById(@PathVariable int id)
	{
		Optional<Students> findStudentsById = studentService.findStudentsById(id);
		return findStudentsById;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Students> deleteStudents(Students students)
	{
		ResponseEntity<Students> responseEntity = new ResponseEntity<Students>(HttpStatus.OK);
		try
		{
			studentService.deleteStudent(students);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			responseEntity= new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	
	@DeleteMapping("/deleteId/{id}")
	public ResponseEntity<Students> deleteStudentsId(@PathVariable int id)
	{
		ResponseEntity<Students> responseEntity = new ResponseEntity<Students>(HttpStatus.OK);
		try
		{
			studentService.deleteStudentsById(id);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			responseEntity= new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Students> updateStudents (@PathVariable int id ,@RequestBody Students students)
	{
		return new ResponseEntity<Students>(studentService.updateStudent(students, id),(HttpStatus.OK));
	}
	
	
	@GetMapping("/class/standard")
	public List<Students> getStudentsByClass(@RequestParam String standard)
	{
		List<Students> findByStandard = studentService.getStudenstByClass(standard);
		return findByStandard;
	}
	
}
