package com.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.beans.Student;
import com.rest.dao.IRestDao;
import com.rest.service.IRestService;

public class RestServiceImpl implements IRestService {

	@Autowired
	IRestDao restDao;
	
	public void addNewStudent(Student student) {
		restDao.addNewStudent(student);
	}

	public List<Student> listStudent() {
		return restDao.listStudent();
	}

	public void studentDelete(int id) {
		restDao.studentDelete(id);
	}

	public List<Student> studentEdit(int id) {
		return restDao.studentEdit(id);
	}

	public void studentupdate(Student student) {
		restDao.studentupdate(student);
	}

}
