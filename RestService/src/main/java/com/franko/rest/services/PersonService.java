package com.franko.rest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.franko.rest.models.Person;

@Service
public interface PersonService {
	public List<Person> findByLastNameOrEmail(String lastName);	
	public boolean enterPerson(Person person);	
	public List<Person> getPersonDetails();
	public List<Person> getAll();
	public boolean deletePerson(long id);
}