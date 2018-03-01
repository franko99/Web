package com.franko.rest.controllers;

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
import com.franko.rest.models.SearchCriteria;
import com.franko.rest.models.User;
import com.franko.rest.services.UserService;

@RestController
public class SearchController {
	
	UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/api/search")
	public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {
		AjaxResponseBody result = new AjaxResponseBody();
		
		if(errors.hasErrors()){
			result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(result);
		}
		
 		List<User>  users = userService.findByUserNameOrEmail(search.getUsername());
		if(users.isEmpty()) {
			result.setMsg("No user found.");
		} else {
			result.setMsg("Success");
		}
		
		result.setUsers(users);
		
		return ResponseEntity.ok(result);
	}
}