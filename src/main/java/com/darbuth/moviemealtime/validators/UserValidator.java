//package com.darbuth.moviemealtime.validators;
//
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//@Component
//public class UserValidator implements Validator {
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return User.class.equals(clazz);
//	}
//
//	@Override
//	public void validate(Object target, Errors errors) {
//		User user = (User) object;
//		if (!user.getPasswordConfirm().equals(user.getPassword())) {
//			errors.rejectValue("passwordConfirm", "Match");
//		}
//	}
//
//	
//}
