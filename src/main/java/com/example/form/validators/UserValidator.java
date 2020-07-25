package com.example.form.validators;

import com.example.form.model.domain.User;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.user.name");
		if (!user.getId().matches("[\\d]{2}[.,][\\d]{3}[.,][\\d]{3}[-][A-Z]{1}")) {
			errors.rejectValue("id", "Pattern.user.id");
		}
	}
	
}
