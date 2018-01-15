package com.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rest.beans.Student;
import com.rest.dao.IRestDao;

public class RestDaoImpl implements IRestDao {

	@Autowired
	private SessionFactory hibernateSessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.hibernateSessionFactory = sf;
	}

	public void addNewStudent(Student student) {
		try {
			Session session = hibernateSessionFactory.openSession();
			session.saveOrUpdate(student);
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Student> listStudent() {
		List<Student> Studentlist = null;
		try {
			Session session = hibernateSessionFactory.openSession();
			Studentlist = session.createQuery("from Student").list();
			System.out.println(Studentlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Studentlist;
	}

	public void studentDelete(int id) {
		try {
			Session session = hibernateSessionFactory.openSession();
			Student student = (Student) session.load(Student.class, id);
			System.out.println(student.getFname());
			if (student != null) {
				session.delete(student);
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> studentEdit(int id) {
		List<Student> list = null;
		try {
			Session session = hibernateSessionFactory.openSession();
			Student Student = (Student) session.load(Student.class, id);
			list = new ArrayList<Student>();
			list.add(Student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void studentupdate(Student student) {
		try {
			Session session = hibernateSessionFactory.openSession();
			session.update(student);
			session.beginTransaction().commit();
			System.out.println("Command successfully executed....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
