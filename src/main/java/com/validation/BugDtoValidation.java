package com.validation;

import com.dto.BugDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class BugDtoValidation implements Validator {
    private static final int MINIMUM_TEXT_LENGTH = 4;

    @Override
    public boolean supports(Class<?> aClass) {
        return BugDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "desc", "description.required");
        BugDto bugDto = (BugDto) o;
        if (bugDto.getTitle().length() < MINIMUM_TEXT_LENGTH) {
            errors.rejectValue("title", "field.min.length",
                    new Object[]{MINIMUM_TEXT_LENGTH},
                    "The title must be at least [" + MINIMUM_TEXT_LENGTH + "] characters in length.");
        }
        if (bugDto.getDesc().length() < MINIMUM_TEXT_LENGTH) {
            errors.rejectValue("desc", "field.min.length",
                    new Object[]{MINIMUM_TEXT_LENGTH},
                    "The description must be at least [" + MINIMUM_TEXT_LENGTH + "] characters in length.");
        }
    }

}
