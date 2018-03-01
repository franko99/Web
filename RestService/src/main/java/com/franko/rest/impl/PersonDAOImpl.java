package com.franko.rest.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.franko.rest.dao.PersonDAO;
import com.franko.rest.models.Person;

@Component
public class PersonDAOImpl implements PersonDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Person> findByLastNameOrEmail(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean enterPerson(Person person) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			session.save(person);
		} catch(Exception e) {
			e.printStackTrace();
			session.close();
			return false;
		}

		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public List<Person> getPersonDetails() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Person.class);
		return criteria.list();
	}
	
	public List<Person> getAll() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Person");
		List<Person> list = q.list();
		return list;
	}

	@Override
	public boolean deletePerson(long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Person person = new Person();
		person.setId(id);
		
		try {
			person = session.get(Person.class, id);
			session.delete(person);
		} catch(Exception e) {
			e.printStackTrace();
			session.close();
			return false;
		}

		session.getTransaction().commit();
		session.close();
		return true;
	}
}