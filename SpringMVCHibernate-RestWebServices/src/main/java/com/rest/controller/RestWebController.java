package com.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.beans.Student;
import com.rest.service.IRestService;

@RestController
public class RestWebController {

	@Autowired
	IRestService restService;

	@GetMapping(value = "/employees", headers = "Accept=application/json")
	public List<Student> getEmployees() {
		List<Student> listOfStudents = new ArrayList<Student>();
		listOfStudents = getStudentList();
		return listOfStudents;
	}

	@GetMapping(value = "/employees/{id}", headers = "Accept=application/json")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		List<Student> listOfStudents = new ArrayList<Student>();
		listOfStudents = getStudentList();
		for (Student Student : listOfStudents) {
			if (Student.getId() == id)
				return new ResponseEntity<Student>(Student, HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}

	// Utiliy method to create Student list.
	public List<Student> getStudentList() {
		List<Student> listOfStudent = new ArrayList<Student>();
		listOfStudent = restService.listStudent();
		return listOfStudent;
	}

	@DeleteMapping(value = "/employee/{id}", headers = "Accept=application/json")
	public List<Student> studentDelete(@PathVariable int id) {
		List<Student> listOfStudents = new ArrayList<Student>();
		restService.studentDelete(id);
		listOfStudents = getStudentList();
		return listOfStudents;
	}

	@GetMapping(value = "/editEmployee/{id}", headers = "Accept=application/json")
	public List<Student> studentEdit(@PathVariable int id) {
		System.out.println(restService.studentEdit(id));
		return restService.studentEdit(id);
	}

	@PutMapping(value = "/updateEmployee", headers = "Accept=application/json")
	public void studentupdate(Student student) {
		restService.studentupdate(student);
	}

}
