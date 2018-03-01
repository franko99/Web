package com.franko.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franko.rest.dao.PersonDAO;
import com.franko.rest.models.Person;
import com.franko.rest.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;

	@Override
	public List<Person> findByLastNameOrEmail(String lastName) {
		return personDAO.findByLastNameOrEmail(lastName);
	}

	@Override
	public boolean enterPerson(Person person) {
		return personDAO.enterPerson(person);
	}

	@Override
	public List<Person> getPersonDetails() {
		return personDAO.getPersonDetails();
	}
	
	@Override
	public List<Person> getAll() {
		return personDAO.getAll();
	}

	@Override
	public boolean deletePerson(long id) {
		return personDAO.deletePerson(id);
	}
}