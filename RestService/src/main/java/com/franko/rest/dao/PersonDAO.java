package com.franko.rest.dao;

import java.util.List;

import com.franko.rest.models.Person;

public interface PersonDAO {	
	public List<Person> findByLastNameOrEmail(String lastName);	
	public boolean enterPerson(Person person);
	public List<Person> getPersonDetails();
	public List<Person> getAll();
	public boolean deletePerson(long id);
}