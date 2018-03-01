package com.franko.rest.controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.franko.rest.models.AjaxResponseBody;
import com.franko.rest.models.DeleteCriteria;
import com.franko.rest.models.EnterPersonCriteria;
import com.franko.rest.models.Person;
import com.franko.rest.services.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping("/api/enterPerson")
	public ResponseEntity<?> enterPerson(@Valid @RequestBody EnterPersonCriteria enter, Errors errors) {
		AjaxResponseBody result = new AjaxResponseBody();

		if (errors.hasErrors()) {
			result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(result);
		}

		String encryptedPass = null;
		try {
			encryptedPass = hashPassword(enter.getPassword());
		} catch (NoSuchAlgorithmException e) {
			result.setMsg("Something went wrong");
			return ResponseEntity.badRequest().body(result);
		}
		
		Person person = new Person(enter.getFirstName(), enter.getLastName(), enter.getEmail(), encryptedPass);

		boolean insert = personService.enterPerson(person);
		if (insert) {
			result.setMsg("Success");
			List<Person> persons = new ArrayList<Person>();
			persons.add(person);
			
			result.setPerson(persons);
		} else {
			result.setMsg("Person not created.");
		}
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/api/deletePerson")
	public ResponseEntity<?> deletePerson(@Valid @RequestBody DeleteCriteria id, Errors errors) {
		AjaxResponseBody result = new AjaxResponseBody();
		
		if(errors.hasErrors()) {
			result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
		}
		
		boolean deleted = personService.deletePerson(Long.parseLong(id.getId()));
		if(deleted) {
			result.setMsg("Success");
		} else {
			result.setMsg("Person not deleted.");
		}
		
		return ResponseEntity.ok(result);
	}

	public String hashPassword(String password) throws NoSuchAlgorithmException {
		String hashedPassword;
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(password.getBytes());
		hashedPassword = new String(messageDigest.digest());

		return hashedPassword;
	}

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
}