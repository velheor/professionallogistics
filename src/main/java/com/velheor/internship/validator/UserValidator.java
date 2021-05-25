package com.velheor.internship.validator;

import com.velheor.internship.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository userRepository;

    public Boolean checkForUserHasThisPhoneNumber(UUID id, String phoneNumber) {
        return userRepository.checkForUserHasThisPhoneNumber(id, phoneNumber);
    }

    public Boolean checkForUserHasThisEmail(UUID id, String email) {
        return userRepository.checkForUserHasThisEmail(id, email);
    }
}
