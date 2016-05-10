package com.validation;

import com.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class UserDtoValidation implements Validator {

    private static final int MINIMUM_PASSWORD_LENGTH = 4;
    private static final int MINIMUM_LOGIN_LENGTH = 4;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "firstname.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "lastname.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
        UserDto userDto = (UserDto) o;
        if (userDto.getLogin().length() < MINIMUM_LOGIN_LENGTH) {
            errors.rejectValue("login", "field.min.length",
                    new Object[]{MINIMUM_LOGIN_LENGTH},
                    "The login must be at least [" + MINIMUM_LOGIN_LENGTH + "] characters in length.");
        }
        if (userDto.getPassword().length() < MINIMUM_PASSWORD_LENGTH) {
            errors.rejectValue("password", "field.min.length",
                    new Object[]{MINIMUM_PASSWORD_LENGTH},
                    "The password must be at least [" + MINIMUM_PASSWORD_LENGTH + "] characters in length.");
        }
    }
}
