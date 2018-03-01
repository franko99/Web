package hello;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
		registry.addViewController("/carResults").setViewName("carResults");
	}
	
	@GetMapping("/person")
	public String showForm(PersonForm personForm) {
		return "form";
	}
	
	@PostMapping("/person")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		
		return "redirect:/results";
	}
	
	@GetMapping("/car")
	public String showCar() {
		return "car";
	}
	
	@SuppressWarnings("unused")
	@PostMapping("/car")
	public String showCarResults() {
		if(!true) {
			return "car";
		}
		
		return "redirect:/carResults";
	}
}