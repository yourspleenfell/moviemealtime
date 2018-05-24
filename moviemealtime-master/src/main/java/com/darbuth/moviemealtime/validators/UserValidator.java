package com.darbuth.moviemealtime.validators;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.darbuth.moviemealtime.models.User;

@Component
public class UserValidator implements Validator {

	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
	private static Pattern pattern;
	
	public UserValidator() {
		pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Match");
		}
		if (!pattern.matcher(user.getEmail()).matches()) {
		errors.rejectValue("email", "Valid");
		}
	}
	
}
