package com.example.form.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegexIdValidator implements ConstraintValidator<RegexId, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.matches("[\\d]{2}[.,][\\d]{3}[.,][\\d]{3}[-][A-Z]{1}")) {
			return true;
		}
		return false;
	}
	
}
