package hello;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
		registry.addViewController("/error").setViewName("error");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/create").setViewName("create");
	}

	@GetMapping("/register")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	@GetMapping("/create")
	public String showCreateForm(CustomerForm customerForm) {
		return "create";
	}

	@PostMapping("/register")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		model.addAttribute(personForm);
		return "results";
	}

}
