package hello;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	@RequestMapping("/")
	public String landingPage() {
		return "page1";
	}
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required=false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping("/ajax")
	public String ajax() {
		return "ajax";
	}
	
	@RequestMapping("/movie")
	public String movie() {
		return "movie";
	}
	
	@RequestMapping("/movieList")
	public String movieList(Model model) {
		return "movieList";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}