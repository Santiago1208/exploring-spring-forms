package com.example.form.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.form.editors.CountryPropertyEditor;
import com.example.form.editors.RolePropertyEditor;
import com.example.form.editors.UppercaseEditor;
import com.example.form.model.domain.Country;
import com.example.form.model.domain.Role;
import com.example.form.model.domain.User;
import com.example.form.services.CountryService;
import com.example.form.services.RoleService;
import com.example.form.validators.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class FormController {

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private CountryService countryService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private CountryPropertyEditor countryPropertyEditor;

	@Autowired
	private RolePropertyEditor rolePropertyEditor;

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		binder.addValidators(userValidator);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "birth", new CustomDateEditor(dateFormat, false));

		binder.registerCustomEditor(String.class, "name", new UppercaseEditor());

		binder.registerCustomEditor(Country.class, "country", countryPropertyEditor);
		binder.registerCustomEditor(Role.class, "roles", rolePropertyEditor);
	}

	@ModelAttribute("countries")
	public List<String> getCountries() {
		return Arrays.asList("Spain", "Mexico", "Chile", "Argentina", "Peru", "Colombia", "Venezuela");
	}

	@ModelAttribute("countryObjects")
	public List<Country> getCountryObjects() {
		return countryService.getCountries();
	}

	@ModelAttribute("countriesMap")
	public Map<String, String> getCountriesMap() {
		Map<String, String> countries = new HashMap<>();
		countries.put("ES", "Spain");
		countries.put("MX", "Mexico");
		countries.put("CL", "Chile");
		countries.put("AR", "Argentina");
		countries.put("PE", "Peru");
		countries.put("CO", "Colombia");
		countries.put("VZ", "Venezuela");
		return countries;
	}

	@ModelAttribute("roles")
	public List<String> getRoles() {
		return Arrays.asList("ROLE_ADMIN", "ROLE_USER", "ROLE_MODERATOR");
	}

	@ModelAttribute("rolesMap")
	public Map<String, String> getRolesMap() {
		Map<String, String> roles = new HashMap<>();
		roles.put("ROLE_ADMIN", "Administrator");
		roles.put("ROLE_USER", "User");
		roles.put("ROLE_MODERATOR", "Moderator");
		return roles;
	}

	@ModelAttribute("rolesService")
	public List<Role> getRolesService() {
		return roleService.getRoles();
	}

	@ModelAttribute("genders")
	public List<String> getGenders() {
		return Arrays.asList("Male", "Female");
	}

	@GetMapping("/form")
	public String form(final Model model) {
		final User user = new User();
		user.setId("12.456.789-K");
		user.setName("Jhon");
		user.setSurname("Doe");
		user.setEnabled(true);
		user.setGender("Male");
		user.setSecretValue("Lorem Ipsum");
		user.setCountry(new Country(3, "CH", "Chile"));
		user.setRoles(Arrays.asList(new Role(2, "ROLE_USER", "User")));
		model.addAttribute("user", user);
		return "form";
	}

	@PostMapping("/form")
	public String process(@Valid final User user, final BindingResult result, final Model model) {
		if (result.hasErrors()) {
			return "form";
		}
		return "redirect:/result";
	}

	@GetMapping("/result")
	public String view(@SessionAttribute(name = "user", required = false) final User user, final Model model, final SessionStatus status) {
		if(user == null) {
			return "redirect:/form";
		}
		model.addAttribute("title", "Created user");
		status.setComplete();
		return "result";
	}

}
