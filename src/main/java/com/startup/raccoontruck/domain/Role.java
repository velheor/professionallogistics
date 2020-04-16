package com.startup.raccoontruck.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, DRIVER, CUSTOMER;

    @Override
    public String getAuthority() {
        return name();
    }
}
