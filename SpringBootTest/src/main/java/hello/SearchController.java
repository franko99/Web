package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
	 UserService userService;
	 
	 @Autowired
	 public void setUserService(UserService userService) {
		 this.userService = userService;
	 }
	 
	 @PostMapping("/api/search/ajax")
	 public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {
		 AjaxResponseBody result = new AjaxResponseBody();
		 
		 if(errors.hasErrors()) {
			 result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			 
			 return ResponseEntity.badRequest().body(result);
		 }
		 
		 List<User> users = userService.findUserNameOrEmail(search.getUsername());
		 if(users.isEmpty()) {
			 result.setMsg("no user found!");
		 } else {
			 result.setMsg("success");
		 }
		 
		 result.setUsers(users);
		 
		 return ResponseEntity.ok(result);
	 }
	 
	 @PostMapping("/api/search/movie")
	 public ResponseEntity<?> getMovie(@Valid @RequestBody MovieWrapper movies, Errors errors) {
		 AjaxResponseBody result = new AjaxResponseBody();
		 
		 List<Movie> moviesList = new ArrayList<Movie>();
		 
		 for(Movie movie: movies.getMovies()) {
			 System.out.println(movie.toString());
			 moviesList.add(movie);
		 }
		 
		 if(errors.hasErrors()) {
			 result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			 
			 return ResponseEntity.badRequest().body(result);
		 }
		 
		 result.setMovies(moviesList);
		 
		 return ResponseEntity.ok(result);
	 }
}