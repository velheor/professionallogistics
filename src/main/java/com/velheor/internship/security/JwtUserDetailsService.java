package com.velheor.internship.security;

import com.velheor.internship.mappers.RoleMapper;
import com.velheor.internship.models.User;
import com.velheor.internship.models.enums.EUserStatus;
import com.velheor.internship.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {

        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new BadCredentialsException("email/password incorrect"));

        return createJwtUser(user);
    }

    public JwtUser createJwtUser(User user) {
        return new JwtUser(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getPassword(),
                roleMapper.toGrantedAuthorities(user.getRoles()),
                user.getStatus().equals(EUserStatus.ACTIVE));
    }
}
