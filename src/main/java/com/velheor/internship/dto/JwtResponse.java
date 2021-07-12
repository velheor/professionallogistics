package com.velheor.internship.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JwtResponse {
    private String accessToken;
    private String refreshToken;
    private static final String TOKEN_TYPE = "Bearer";
}
