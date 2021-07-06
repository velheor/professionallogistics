package com.velheor.internship.validator;

import com.velheor.internship.repository.UserRepository;
import com.velheor.internship.validator.annotations.EmailConstraint;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@NoArgsConstructor
public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    private UserRepository userRepository;

    @Autowired
    public EmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(EmailConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userRepository.checkForUniqueEmail(email);
    }
}
