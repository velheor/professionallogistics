package com.velheor.internship.validator;


import com.velheor.internship.repository.UserRepository;
import com.velheor.internship.validator.annotations.PhoneNumberConstraint;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {

    private final UserRepository userRepository;

    @Override
    public void initialize(PhoneNumberConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return userRepository.checkForUniquePhoneNumber(phoneNumber);
    }
}
