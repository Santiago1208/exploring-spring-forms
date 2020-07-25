package com.example.form.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = RegexIdValidator.class)
public @interface RegexId {

	String message() default "Invalid ID";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
