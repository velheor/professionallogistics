package com.velheor.internship.validator;

import com.velheor.internship.repository.UserRepository;
import com.velheor.internship.validator.annotations.PhoneNumberConstraint;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@NoArgsConstructor
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {

    private UserRepository userRepository;

    @Autowired
    public PhoneNumberValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(PhoneNumberConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        return userRepository.checkForUniquePhoneNumber(phoneNumber);
    }
}
