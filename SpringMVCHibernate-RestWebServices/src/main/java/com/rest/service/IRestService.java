package com.rest.service;

import java.util.List;

import com.rest.beans.Student;

public interface IRestService {
	public void addNewStudent(Student student);
	public List<Student> listStudent();
	public void studentDelete(int id);
	public List<Student> studentEdit(int id);
	public void studentupdate(Student student);
}
