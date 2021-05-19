package com.velheor.internship.config;

import com.velheor.internship.security.JwtUser;
import com.velheor.internship.security.JwtUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static com.velheor.internship.utils.TestUtils.USER1;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Configuration
@ComponentScan(basePackages = {
        "com.velheor.internship.security",
        "com.velheor.internship.mappers"
}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = JwtUserDetailsService.class)})
public class WebTestConfig {

    @Bean
    public JwtUserDetailsService userDetailsService() {
        JwtUserDetailsService jwtUserDetailsService = mock(JwtUserDetailsService.class);
        when(jwtUserDetailsService.loadUserByUsername(USER1.getEmail())).thenReturn(new JwtUser(USER1));
        return jwtUserDetailsService;
    }
}
